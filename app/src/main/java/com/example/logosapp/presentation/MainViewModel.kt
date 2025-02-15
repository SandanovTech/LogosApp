package com.example.logosapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logosapp.domain.usecases.GetWordsUseCase
import com.example.logosapp.presentation.screenState.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

private const val LOG_TAG = "MainViewModel"

class MainViewModel(
    private val getWordsUseCase: GetWordsUseCase,
) : ViewModel(), KoinComponent {
    private val _state: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Initial)
    val state: MutableStateFlow<ScreenState> = _state

    fun loadWordDescription(inputText: String, forceRefresh: Boolean) {
        _state.value = ScreenState.Loading
        viewModelScope.launch {
            if (inputText.isNotEmpty()) {
                val listOfWords = getWordsUseCase.invoke(inputText, forceRefresh)
                if (listOfWords.isEmpty()) {
                    _state.value = ScreenState.Error
                } else {
                    _state.value = ScreenState.Success(listOfWords)
                }
            } else {
                _state.value = ScreenState.Error
            }
        }
    }
}