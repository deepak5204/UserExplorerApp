package com.example.userexplorerapp.uiState

import com.example.userexplorerapp.model.UserDto

data class UserUiState(
    val isLoading: Boolean = false,
    val users: List<UserDto> = emptyList(),
    val error: String? = null
)