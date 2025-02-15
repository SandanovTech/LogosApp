package com.example.logosapp.di

import com.example.logosapp.domain.usecases.GetWordsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetWordsUseCase(get()) }
}