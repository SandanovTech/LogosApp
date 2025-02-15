package com.example.logosapp.di

import androidx.room.Room
import com.example.logosapp.data.local.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build()
    }
    single { get<AppDatabase>().wordDao() }
}