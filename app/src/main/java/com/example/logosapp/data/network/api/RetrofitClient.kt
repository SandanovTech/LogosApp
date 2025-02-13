package com.example.logosapp.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.api-ninjas.com/v1/logo/"

class RetrofitClient {
    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getInstance() : LogosApi {
        return retrofit.create(LogosApi::class.java)
    }
}