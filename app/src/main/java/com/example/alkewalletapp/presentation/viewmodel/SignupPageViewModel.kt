package com.example.alkewalletapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.response.UserResponse
import com.example.alkewalletapp.domain.UserUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * ViewModel para la página de registro.
 * Esta clase maneja la lógica de registro de usuario, validación de datos y almacenamiento
 * de la información del usuario en `SharedPreferences`.
 */
class SignupPageViewModel(
   // application: Application,
    private val useCase: UserUseCase) : ViewModel () {
   // private val sharedPreferences: SharedPreferences =
    //    application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    private val newUser = MutableLiveData<Result<Response<UserResponse>>>()
    val livedata : LiveData<Result<Response<UserResponse>>> = newUser

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

        if (!validateemail(email)) {
            toastMessage.value = "Correo electrónico no válido"
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

//        with(sharedPreferences.edit()) {
//            putString("name", name)
//            putString("apellido", apellido)
//            putString("email", email)
//            putString("password", password)
//            apply()
//        }

        viewModelScope.launch {
            try {
                var response = useCase.createUser(UserResponse( 0,name, apellido, email,
                    password,null,1,null,null))
                if (response.isSuccessful) {
                    newUser.postValue(Result.success(response))
                } else {
                    newUser.postValue(Result.failure(Exception("Error al registrar usuario")))
                }
            } catch (e: Exception) {
                newUser.postValue(Result.failure(e))
            }
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

    private fun validateemail(email: String): Boolean {
        return email.length >= 8 && email.matches(Regex(
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
    }



}
