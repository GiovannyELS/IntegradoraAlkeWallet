package com.example.alkewalletapp.presentation.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentHomePageBinding
import com.example.alkewalletapp.presentation.adapter.TransactionAdapter
import com.example.alkewalletapp.presentation.viewmodel.HomePageViewModel

/**
 * Fragmento que representa el home page de la aplicación.
 */
class HomePage : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private val viewModel: HomePageViewModel by activityViewModels()

    /**
     * Se llama cuando el fragmento se crea.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * Infla el diseño del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama inmediatamente después de que se ha llamado a onCreateView().
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)

        // Configuración de la imagen de perfil para navegar a la pantalla "profile".
        binding.imageView10.setOnClickListener {
            navController.navigate(R.id.action_homePage_to_profilePage2)
        }

        // Configuración del botón "botonVerde1" para navegar a la pantalla "SendMoney".
        binding.botonVerde1.setOnClickListener {
            navController.navigate(R.id.action_homePage_to_sendMoney)
        }

        // Configuración del botón "botonIngresar1" para navegar a la pantalla "RequestMoney".
        binding.botonIngresar1.setOnClickListener {
            navController.navigate(R.id.action_homePage_to_requestMoney)
        }

        // Configuración del RecyclerView para mostrar las transacciones.
        binding.recyclerUser.layoutManager = LinearLayoutManager(context)
        val adapter = TransactionAdapter()
        binding.recyclerUser.adapter = adapter

        // Observa los cambios en las transacciones y actualiza el RecyclerView.
        viewModel.transaction.observe(viewLifecycleOwner) { transaction ->
            (binding.recyclerUser.adapter as TransactionAdapter).transactions = transaction
        }

        // Obtiene el nombre de usuario y saldo de las preferencias compartidas.
        val sharedPrefs = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val userName = sharedPrefs.getString("name", "Usuario")
        val userBalance = sharedPrefs.getString("balance", "25000.00")

        // Muestra el saludo al usuario y su saldo.
        binding.textView8.text = "Hola, $userName!"
        binding.transactionAmount.text = "$ $userBalance"
    }
}