package com.example.alkewalletapp.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.databinding.FragmentSignupPageBinding
import com.example.alkewalletapp.presentation.viewmodel.SignupPageViewModel

/**
 * Fragmento que representa la página de registro de la aplicación.
 */
class SignupPage : Fragment() {
    /**
     * Se crean las variables para el binding y el view model.
     */

    private var _binding: FragmentSignupPageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SignupPageViewModel by viewModels()

    /**
     * Infla el diseño para este fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Se llama inmediatamente después de que se ha llamado a onCreateView().
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del botón "Crear cuenta" para registrar un nuevo usuario.
        binding.botoncrearcuenta2.setOnClickListener {
            registerUser()
        }

        // Configuración del texto "Ya tienes una cuenta" para navegar a la página de inicio de sesión.
        binding.textyatienesuna.setOnClickListener {
            findNavController().navigate(R.id.action_signupPage_to_loginPage)
        }

        // Se genera el observador
        viewModel.toastMessage.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        })
    }

    /**
     * Registra un nuevo usuario utilizando los datos introducidos en el formulario de registro.
     */
    private fun registerUser() {
        val name = binding.editTextname.text.toString()
        val apellido = binding.editTextApellido.text.toString()
        val email = binding.editTextmail.text.toString()
        val password = binding.editTextContra.text.toString()
        val rePassword = binding.editTextRePassword.text.toString()

        viewModel.registerUser(name, apellido, email, password, rePassword, findNavController())
    }

    /**
     * Se llama cuando la vista del fragmento se destruye para liberar recursos.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
