package com.example.logosapp.domain.repository

import com.example.logosapp.domain.model.Logo

interface Repository {
    suspend fun getLogos(company : String) : List<Logo>
}