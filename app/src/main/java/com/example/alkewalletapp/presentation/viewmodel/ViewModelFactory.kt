package com.example.alkewalletapp.presentation.viewmodel

import android.app.Application
import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletapp.domain.UserUseCase

class ViewModelFactory (private val useCase: UserUseCase)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        return when {
            modelClass.isAssignableFrom(SignupPageViewModel::class.java) -> {
                SignupPageViewModel(useCase) as T
            }

            modelClass.isAssignableFrom(LoginPageViewModel::class.java) -> {
                LoginPageViewModel(useCase) as T
            }
            else -> {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}