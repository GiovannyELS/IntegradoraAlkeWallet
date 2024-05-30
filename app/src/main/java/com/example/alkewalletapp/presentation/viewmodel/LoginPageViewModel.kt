package com.example.alkewalletapp.presentation.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * ViewModel para la página de inicio de sesión.
 * Esta clase maneja la lógica de autenticación del usuario utilizando las
 * credenciales almacenadas en `SharedPreferences`.
 */
class LoginPageViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    private val storedEmail = sharedPreferences.getString("email", null)
    private val storedPassword = sharedPreferences.getString("password", null)

    /**
     * Valida las credenciales proporcionadas por el usuario.
     */
    fun validateCredentials(username: String, password: String): Boolean {
        Log.i("LoginPageViewModel", "Username: $username")
        return username == storedEmail && password == storedPassword
    }
}
