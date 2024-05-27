package com.example.alkewalletapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletapp.R
import com.example.alkewalletapp.data.local.User

class HomePageViewModel : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        val exampleUsers = listOf(
            User("1", "Alice", 150.0, R.drawable.profilepicture1),
            User("2", "Giovanny", 100.0, R.drawable.profilepicture2),
            User("3", "Charlie", 200.0, R.drawable.profilepicture3),
            User("4", "David", 250.0, R.drawable.profilepicture4),
            User("5", "Eve", 300.0, R.drawable.profilepicture5),
            User("6", "Frank", 350.0, R.drawable.profilepicture6)
        )
        _users.value = exampleUsers
    }
}
