package com.example.logosapp.data.repository

import com.example.logosapp.data.network.api.LogosApi
import com.example.logosapp.domain.model.Logo
import com.example.logosapp.domain.repository.Repository

class RepositoryImpl(private val api : LogosApi) : Repository {

//    private val api: LogosApi = RetrofitClient().getInstance()

    override suspend fun getLogos(company: String): List<Logo> {
        return api.getLogos(company).map {
            it.toDao()
            it.toDomain()
        }
    }
}