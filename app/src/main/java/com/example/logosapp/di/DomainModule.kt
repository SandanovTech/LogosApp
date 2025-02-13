package com.example.logosapp.di

import com.example.logosapp.domain.usecases.GetLogosUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetLogosUseCase(get()) }
}