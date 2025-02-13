package com.example.logosapp.domain.usecases

import com.example.logosapp.domain.model.Logo
import com.example.logosapp.domain.repository.Repository

class GetLogosUseCase(private val repository: Repository) {
    suspend operator fun invoke(company : String) : List<Logo> {
        return repository.getLogos(company)
    }
}