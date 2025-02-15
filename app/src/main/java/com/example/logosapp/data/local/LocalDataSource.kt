package com.example.logosapp.data.local

import com.example.logosapp.data.local.model.WordEntity

interface LocalDataSource {
    suspend fun getCachedWords(word: String): List<WordEntity>
}