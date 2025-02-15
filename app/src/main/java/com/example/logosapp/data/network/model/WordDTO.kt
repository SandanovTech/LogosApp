package com.example.logosapp.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class WordDTO(val name: String, val ticker: String, val image: String)