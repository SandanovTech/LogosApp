package com.example.logosapp.data.network.mapper

import com.example.logosapp.data.local.model.WordEntity
import com.example.logosapp.data.network.model.WordDTO
import com.example.logosapp.domain.model.Word

object WordNetworkMapper {
    fun toDomain(entity: WordDTO): Word {
        return Word(entity.name, entity.ticker, entity.image)
    }

    fun toEntity(word: WordDTO): WordEntity {
        return WordEntity(word.name, word.ticker, word.image)
    }

    fun toDTO(word: Word): WordDTO {
        return WordDTO(word.name, word.ticker, word.image)
    }

    fun toListDomain(entities: List<WordDTO>): List<Word> {
        return entities.map { toDomain(it) }
    }

    fun toListEntity(words: List<WordDTO>): List<WordEntity> {
        return words.map { toEntity(it) }
    }

    fun toListDTO(words: List<Word>): List<WordDTO> {
        return words.map { toDTO(it) }
    }
}