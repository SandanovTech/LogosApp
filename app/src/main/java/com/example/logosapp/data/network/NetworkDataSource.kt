package com.example.logosapp.data.network

import com.example.logosapp.data.network.model.WordDTO

interface NetworkDataSource {
    suspend fun getWords(word :String): List<WordDTO>
}