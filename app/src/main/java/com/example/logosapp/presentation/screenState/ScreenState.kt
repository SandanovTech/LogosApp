package com.example.logosapp.presentation.screenState

import com.example.logosapp.domain.model.Word

sealed class ScreenState {
    data object Initial : ScreenState()
    data object Loading : ScreenState()
    data class Success(val words: List<Word>) : ScreenState()
    data object Error : ScreenState()
}