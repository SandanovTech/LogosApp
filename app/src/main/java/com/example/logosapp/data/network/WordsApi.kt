package com.example.logosapp.data.network

import com.example.logosapp.data.network.model.WordDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WordsApi {
    @GET("logo")
    suspend fun getWord(@Query("name") word : String): List<WordDTO>
}