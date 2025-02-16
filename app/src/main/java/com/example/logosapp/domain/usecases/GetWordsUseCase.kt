package com.example.logosapp.domain.usecases

import com.example.logosapp.domain.model.Word
import com.example.logosapp.domain.repository.Repository

class GetWordsUseCase(private val repository: Repository) {
    suspend operator fun invoke(word :String) : List<Word> {
        return repository.getWords(word)
    }
}