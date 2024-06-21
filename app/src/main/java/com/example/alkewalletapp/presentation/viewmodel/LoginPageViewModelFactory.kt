//package com.example.alkewalletapp.presentation.viewmodel
//
//import android.content.SharedPreferences
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.alkewalletapp.presentation.viewmodel.LoginPageViewModel
//
//class LoginPageViewModelFactory(private val sharedPreferences: SharedPreferences) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginPageViewModel::class.java)) {
//            return LoginPageViewModel(sharedPreferences) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
