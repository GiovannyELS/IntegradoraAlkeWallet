package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentLoginsignupBinding

/**
 * Fragmento que representa la página inicial de opciones para iniciar sesión o registrarse.
 */
class Loginsignup : Fragment() {

    lateinit var binding: FragmentLoginsignupBinding

    /**
     * Se llama cuando el fragmento se crea.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            // Manejo de argumentos si es necesario
        }
    }

    /**
     * Infla el diseño para este fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginsignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama inmediatamente después de que se ha llamado a onCreateView(),
     * y se utiliza para el ingreso a crear cuenta o logearse.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController(view)
        val botoncrearcuenta = binding.botoncrearcuenta
        val yatienescuenta = binding.tienescuentatext

        // Navega a la página de registro cuando se hace clic en el botón "Crear cuenta".
        botoncrearcuenta.setOnClickListener {
            navController.navigate(R.id.action_loginsignup_to_signupPage)
        }

        // Navega a la página de inicio de sesión cuando se hace clic en el texto "Ya tienes cuenta?".
        yatienescuenta.setOnClickListener {
            navController.navigate(R.id.action_loginsignup_to_loginPage)
        }
    }
}
