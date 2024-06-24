package com.example.alkewalletapp.data.repository

import com.example.alkewalletapp.data.model.User
import com.example.alkewalletapp.data.response.LoginRequest
import com.example.alkewalletapp.data.response.LoginResponse
import com.example.alkewalletapp.data.response.UserResponse
import retrofit2.Response

interface UserRepository {

    suspend fun crearUser(user: UserResponse): Response<UserResponse>

    suspend fun loginUser(user: LoginRequest): Response<LoginResponse>

    suspend fun insertarUsuarioBaseDatos(user: User)

}
