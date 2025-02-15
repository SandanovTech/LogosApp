package com.example.logosapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey val name: String,
    val ticker: String,
    val image: String,
)