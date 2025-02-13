package com.example.logosapp.di

import com.example.logosapp.data.network.api.LogosApi
import com.example.logosapp.data.repository.RepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single {
        provideRetrofit(get())
//        Retrofit.Builder()l
//            .baseUrl("https://api.api-ninjas.com/v1/logo/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(LogosApi::class.java)
    }

    single { get<Retrofit>().create(LogosApi::class.java) }

    single { provideOkHttpClient() }

    single { RepositoryImpl(get()) }
}