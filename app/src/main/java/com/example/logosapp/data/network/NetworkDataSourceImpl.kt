package com.example.logosapp.data.network

import android.util.Log
import com.example.logosapp.data.local.dao.WordDao
import com.example.logosapp.data.network.mapper.WordNetworkMapper
import com.example.logosapp.data.network.model.WordDTO

private const val LOG_TAG = "NetworkDataSourceImpl"

class NetworkDataSourceImpl(private val api: WordsApi, private val dao: WordDao) :
    NetworkDataSource {
    override suspend fun getWords(word: String): List<WordDTO> {
        return try {
            val response = api.getWord(word)
            response.map { dao.insertWords(WordNetworkMapper.toEntity(it)) }
            response
        } catch (e: Exception) {
            Log.e(LOG_TAG, e.message.toString())
            emptyList()
        }
    }
}