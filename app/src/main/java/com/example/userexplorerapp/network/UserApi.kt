package com.example.userexplorerapp.network

import com.example.userexplorerapp.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): UserResponse
}