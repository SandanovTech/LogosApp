package com.example.logosapp.domain.repository

import com.example.logosapp.domain.model.Word

interface Repository {
    suspend fun getWords(word :String, forceRefresh : Boolean): List<Word>
}