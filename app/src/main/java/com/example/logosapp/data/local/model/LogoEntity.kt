package com.example.logosapp.data.local.model

import androidx.room.Entity

@Entity
data class LogoEntity(val name: String, val ticker: String, val image: String)