package com.example.userexplorerapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userexplorerapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private  val repository = UserRepository()

    init {
        getUsers()
    }

    private fun getUsers() {

        viewModelScope.launch {

            try {

                val users = repository.getUsers()

                Log.d("VM", users.toString())

            } catch (e: Exception) {

                Log.e("VM", e.message ?: "")

            }

        }
    }
}