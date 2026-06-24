package com.example.userexplorerapp.repository

import com.example.userexplorerapp.model.UserDto
import com.example.userexplorerapp.network.UserApi

class UserRepository(
    private val api: UserApi
) {
    suspend fun getUsers(): List<UserDto> {
        return api.getUsers(1).data
    }
}