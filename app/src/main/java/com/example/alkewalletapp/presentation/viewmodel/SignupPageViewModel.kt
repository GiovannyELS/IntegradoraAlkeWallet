package com.example.alkewalletapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.alkewalletapp.R

/**
 * ViewModel para la página de registro.
 * Esta clase maneja la lógica de registro de usuario, validación de datos y almacenamiento
 * de la información del usuario en `SharedPreferences`.
 */
class SignupPageViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    /**
     * Mensaje de notificación para el usuario.
     */
    val toastMessage = MutableLiveData<String>()

    /**
     * Registra un nuevo usuario con los datos proporcionados.
     *
     * name El nombre del usuario.
     * apellido El apellido del usuario.
     * email El correo electrónico del usuario.
     * password La contraseña del usuario.
     * rePassword La confirmación de la contraseña del usuario.
     * navController El controlador de navegación para redirigir a otras pantallas.
     */
    fun registerUser(
        name: String,
        apellido: String,
        email: String,
        password: String,
        rePassword: String,
        navController: NavController
    ) {
        if (name.isEmpty() || apellido.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            toastMessage.value = "Por favor, complete todos los campos."
            return
        }

        if (!validateName(name)) {
            toastMessage.value = "Nombre no válido"
            return
        }

        if (!validatePassword(password)) {
            toastMessage.value = "La contraseña debe tener al menos 8 caracteres"
            return
        }

        if (password != rePassword) {
            toastMessage.value = "Las contraseñas no coinciden."
            return
        }

        with(sharedPreferences.edit()) {
            putString("name", name)
            putString("apellido", apellido)
            putString("email", email)
            putString("password", password)
            apply()
        }

        toastMessage.value = "Registro exitoso."
        navController.navigate(R.id.action_signupPage_to_loginsignup)
    }

    /**
     * Valida que el nombre del usuario sea válido.
     */
    private fun validateName(name: String): Boolean {
        return name.length >= 4 && name.matches(Regex("^[a-zA-Z\\s]+$"))
    }

    /**
     * Valida que la contraseña del usuario sea válida.
     */
    private fun validatePassword(password: String): Boolean {
        return password.length >= 8
    }
}
