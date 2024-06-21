package com.example.alkewalletapp.presentation.ui.fragments


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.database.AppDatabase
import com.example.alkewalletapp.data.network.api.WalletServiceAPI
import com.example.alkewalletapp.data.network.retrofit.RetrofitHelper
import com.example.alkewalletapp.data.repository.RepositoryImp
import com.example.alkewalletapp.databinding.FragmentLoginPageBinding
import com.example.alkewalletapp.domain.UserUseCase
import com.example.alkewalletapp.presentation.viewmodel.LoginPageViewModel
import com.example.alkewalletapp.presentation.viewmodel.SignupPageViewModel
import com.example.alkewalletapp.presentation.viewmodel.ViewModelFactory


/**
 * Fragmento que representa la página de inicio de sesión de la aplicación.
 */
class LoginPage : Fragment() {

    private var _binding: FragmentLoginPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var validator: LoginPageViewModel
    private lateinit var viewModel: LoginPageViewModel

    /**
     * Se llama cuando el fragmento se crea. Inicializa las variables sharedPreferences y validator.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        sharedPreferences =
//            requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//       // validator = ViewModelProvider(this, LoginPageViewModelFactory(sharedPreferences)).get(
//      //      LoginPageViewModel::class.java
//      //  )
    }

    /**
     * Infla el diseño para este fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama inmediatamente después de que se ha llamado a onCreateView().
     * Tiene los llamados para la navegación login por binding y validacion de credenciales
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()
        val botonlogin = binding.botonlogin
        val crearnuevacuenta = binding.textcrearnuevacuenta

        val apiservice = RetrofitHelper.getRetrofit().create(WalletServiceAPI::class.java)
        val application = requireActivity().application
        val baseDatos = AppDatabase.getDatabase(application)
        val repository = RepositoryImp (apiservice, baseDatos.userDAO())
        val useCase = UserUseCase(repository)
        val viewModelFactory = ViewModelFactory(useCase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginPageViewModel::class.java)


        botonlogin.setOnClickListener {
            val inputUsername = binding.editTextUsername?.text.toString()
            val inputPassword = binding.editTextPassword?.text.toString()
           // val isValid = validator.validateCredentials(inputUsername, inputPassword)
            viewModel.login(inputUsername, inputPassword)

            viewModel.userLoginLV.observe(viewLifecycleOwner){result ->
                result.onSuccess {response ->
                    val token = response.body()?.accessToken.toString()
                    viewModel.almacenarEnBaseDato(inputUsername,inputPassword, token)
                    Log.i("LoginPage", "Credentials valid: $token")
                    navController.navigate(R.id.action_loginPage_to_homePage)
                }
            }
        }

        crearnuevacuenta.setOnClickListener {
            navController.navigate(R.id.action_loginPage_to_signupPage)
        }
    }

    /**
     * Se llama cuando la vista del fragmento se destruye para liberar recursos.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
