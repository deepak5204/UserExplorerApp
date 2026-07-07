package com.example.userexplorerapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userexplorerapp.repository.UserRepository
import com.example.userexplorerapp.presentation.state.UserUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    private val _uiState = MutableStateFlow(UserUiState())
    val uiState = _uiState.asStateFlow()


    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {

            Log.d("TAG", "getUsers: ")

            _uiState.value = _uiState.value.copy(
                isLoading = true, error = null
            )
            try {
                val users = repository.getUsers()
                Log.d("userList", _uiState.value.users.toString())
                _uiState.value = _uiState.value.copy(
                    isLoading = false, users = users
                )
            }
            catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message,
                )
                Log.e("VM", e.message ?: "")
            }
        }
    }
}