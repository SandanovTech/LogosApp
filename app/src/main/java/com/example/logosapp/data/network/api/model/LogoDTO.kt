package com.example.logosapp.data.network.api.model

import com.example.logosapp.domain.model.LogoDO
import kotlinx.serialization.Serializable

@Serializable
data class LogoDTO(val name: String, val ticker: String, val image: String) {
    fun LogoDTO.toDomain(): LogoDO {
        return LogoDO(name, ticker, image)
    }
}