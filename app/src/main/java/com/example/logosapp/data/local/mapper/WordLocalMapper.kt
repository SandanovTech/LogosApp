package com.example.logosapp.data.local.mapper

import com.example.logosapp.data.local.model.WordEntity
import com.example.logosapp.data.network.model.WordDTO
import com.example.logosapp.domain.model.Word

object WordLocalMapper {
    fun toDomain(entity: WordEntity): Word {
        return Word(entity.name, entity.ticker, entity.image)
    }
    fun toDomainFromApi(entity: WordDTO): Word {
        return Word(entity.name, entity.ticker, entity.image)
    }

    fun toEntity(word: Word): WordEntity {
        return WordEntity(word.name, word.ticker, word.image)
    }

    fun toListDomain(entities: List<WordEntity>): List<Word> {
        return entities.map { Word(it.name, it.ticker, it.image) }
    }

    fun toListDomainFromApi(word: List<WordDTO>): List<Word> {
        return word.map { Word(it.name, it.ticker, it.image) }
    }

    fun toListEntity(words: List<Word>): List<WordEntity> {
        return words.map { WordEntity(it.name, it.ticker, it.image) }
    }
}