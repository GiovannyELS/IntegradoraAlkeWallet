package com.example.alkewalletapp.presentation.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alkewalletapp.data.model.User
import com.example.alkewalletapp.data.response.LoginRequest
import com.example.alkewalletapp.data.response.LoginResponse
import com.example.alkewalletapp.domain.UserUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * ViewModel para la página de inicio de sesión.
 * Esta clase maneja la lógica de autenticación del usuario utilizando las
 * credenciales almacenadas en `SharedPreferences`.
 */
class LoginPageViewModel(private val useCase: UserUseCase) : ViewModel() {
    //private val sharedPreferences: SharedPreferences) : ViewModel() {
   // private val storedEmail = sharedPreferences.getString("email", null)
    //private val storedPassword = sharedPreferences.getString("password", null)

    // LiveData para almacenar el estado de la autenticación
private val userLogin = MutableLiveData<Result<Response<LoginResponse>>>()
    val userLoginLV: LiveData <Result<Response<LoginResponse>>> = userLogin


    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = useCase.logingUser(LoginRequest(email, password))
                if (response.isSuccessful){
                    val result= Result.success(response)
                    userLogin.postValue(result)

                }else{

                    userLogin.postValue(Result.failure(Exception("Error en el login")))
                }
            } catch (e: Exception) {
                userLogin.postValue(Result.failure(e))
            }
        }
    }

    fun almacenarEnBaseDato (email: String, password: String, token: String){
        viewModelScope.launch {
            useCase.insertUser(User(email, password, token))
        }
    }

    /**
     * Valida las credenciales proporcionadas por el usuario.
     */
//    fun validateCredentials(username: String, password: String): Boolean {
//        Log.i("LoginPageViewModel", "Username: $username")
//        return username == storedEmail && password == storedPassword
//    }
}
