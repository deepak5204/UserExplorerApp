package com.example.userexplorerapp.repository

import com.example.userexplorerapp.model.UserDto
import com.example.userexplorerapp.network.RetrofitInstance
import com.example.userexplorerapp.network.UserApi

class UserRepository{
    suspend fun getUsers(): List<UserDto> {
        return RetrofitInstance.api.getUsers(1)
    }
}
