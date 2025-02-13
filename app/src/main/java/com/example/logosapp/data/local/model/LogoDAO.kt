package com.example.logosapp.data.local.model

import androidx.room.Dao

@Dao
data class LogoDAO(val name: String, val ticker: String, val image: String)