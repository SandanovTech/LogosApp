package com.example.logosapp.di

import com.example.logosapp.data.local.LocalDataSource
import com.example.logosapp.data.local.LocalDataSourceImpl
import com.example.logosapp.data.network.NetworkDataSource
import com.example.logosapp.data.network.NetworkDataSourceImpl
import com.example.logosapp.data.network.WordsApi
import com.example.logosapp.data.repository.RepositoryImpl
import com.example.logosapp.domain.repository.Repository
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single { provideOkHttpClient() }

    single { provideRetrofit(get()) }

    single { get<Retrofit>().create(WordsApi::class.java) }

    single<Repository> { RepositoryImpl(get(), get()) }

    single<NetworkDataSource> { NetworkDataSourceImpl(get(), get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }
}