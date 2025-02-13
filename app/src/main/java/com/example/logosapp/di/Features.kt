package com.example.logosapp.di

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.api-ninjas.com/v1/logo/"

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder()
            .addHeader("X-Api-Key", "0aZLMH/yBMNGKV3qVgWPmg==5TthwTTjUyPkzI6H")
            .build()
        it.proceed(request)
    }.build()
}