package com.example.alkewalletapp.presentation.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory para crear instancias de [LoginPageViewModel].
 * Esta clase permite la creación de [LoginPageViewModel] con un constructor que
 * requiere SharedPreferences.
 */
class LoginPageViewModelFactory(private val sharedPreferences: SharedPreferences) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginPageViewModel::class.java)) {
            return LoginPageViewModel(sharedPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
