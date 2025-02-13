package com.example.logosapp.data.network.api

import com.example.logosapp.data.network.api.model.LogoDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface LogosApi {
    @GET("{company}")
    suspend fun getLogos(@Query("company") company: String): List<LogoDTO>
}