package com.example.logosapp.data.network.api.model

import com.example.logosapp.data.local.model.LogoEntity
import com.example.logosapp.domain.model.Logo
import kotlinx.serialization.Serializable

@Serializable
data class LogoDTO(val name: String, val ticker: String, val image: String) {
    fun toDomain(): Logo {
        return Logo(name, ticker, image)
    }

    fun toDao(): LogoEntity {
        return LogoEntity(name, ticker, image)
    }
}