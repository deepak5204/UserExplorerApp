package com.example.userexplorerapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    val api: UserApi = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserApi::class.java)
}