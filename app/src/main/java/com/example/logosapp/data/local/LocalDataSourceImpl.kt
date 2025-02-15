package com.example.logosapp.data.local

import com.example.logosapp.data.local.dao.WordDao
import com.example.logosapp.data.local.model.WordEntity

class LocalDataSourceImpl(private val dao: WordDao) : LocalDataSource {
    override suspend fun getCachedWords(word: String): List<WordEntity> {
        return dao.getAllWords(word)
    }
}