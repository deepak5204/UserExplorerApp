package com.example.userexplorerapp.presentation.state

import com.example.userexplorerapp.model.UserDto

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<UserDto> = emptyList(),
    val error: String? = null
)