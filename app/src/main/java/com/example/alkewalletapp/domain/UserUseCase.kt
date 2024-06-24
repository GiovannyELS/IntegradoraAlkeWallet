package com.example.alkewalletapp.domain

import com.example.alkewalletapp.data.model.User
import com.example.alkewalletapp.data.repository.UserRepository
import com.example.alkewalletapp.data.response.LoginRequest
import com.example.alkewalletapp.data.response.LoginResponse
import com.example.alkewalletapp.data.response.UserResponse
import retrofit2.Response


class UserUseCase(private val userRepository: UserRepository) {

    suspend fun createUser (user: UserResponse): Response<UserResponse> {
        return userRepository.crearUser(user)
    }


    suspend fun logingUser (user: LoginRequest): Response<LoginResponse> {
        return userRepository.loginUser(user)
    }

    suspend fun insertUser (user: User){
        return userRepository.insertarUsuarioBaseDatos(user)
    }

}