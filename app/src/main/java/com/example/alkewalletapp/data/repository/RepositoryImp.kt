package com.example.alkewalletapp.data.repository

import com.example.alkewalletapp.data.local.dao.UserDao
import com.example.alkewalletapp.data.model.User
import com.example.alkewalletapp.data.network.api.WalletServiceAPI
import com.example.alkewalletapp.data.response.LoginRequest
import com.example.alkewalletapp.data.response.LoginResponse
import com.example.alkewalletapp.data.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RepositoryImp (private val userApi: WalletServiceAPI,
                     private val userDao: UserDao
    ):UserRepository {

    override suspend fun crearUser(user: UserResponse): Response<UserResponse> {
        return withContext(Dispatchers.IO) {
            userApi.registerUser(user)
        }
    }

    override suspend fun loginUser(user: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            userApi.userLogin(user)
        }
    }

    override suspend fun insertarUsuarioBaseDatos(user: User) {
        return withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }
}