package com.example.logosapp.data.repository

import com.example.logosapp.data.helper.NetworkHelper
import com.example.logosapp.data.local.LocalDataSource
import com.example.logosapp.data.local.mapper.WordLocalMapper
import com.example.logosapp.data.network.NetworkDataSource
import com.example.logosapp.data.network.mapper.WordNetworkMapper
import com.example.logosapp.domain.model.Word
import com.example.logosapp.domain.repository.Repository

class RepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val networkConnection: NetworkHelper,
) : Repository {
    override suspend fun getWords(word: String): List<Word> {
        return if (networkConnection.isWifiConnected.value) {
            val wordsDTO = networkDataSource.getWords(word)
            wordsDTO.forEach {
                WordLocalMapper.toDomainFromApi(it)
            }
            WordNetworkMapper.toListDomain(wordsDTO)
        } else {
            WordLocalMapper.toListDomain(localDataSource.getCachedWords(word))
        }
    }
}