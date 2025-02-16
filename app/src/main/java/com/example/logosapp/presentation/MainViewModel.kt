package com.example.logosapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logosapp.data.helper.NetworkHelper
import com.example.logosapp.domain.usecases.GetWordsUseCase
import com.example.logosapp.presentation.screenState.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

private const val LOG_TAG = "MainViewModel"

class MainViewModel(
    private val getWordsUseCase: GetWordsUseCase,
    private val networkHelper: NetworkHelper,
) : ViewModel(), KoinComponent {
    private val _state: MutableStateFlow<ScreenState> = MutableStateFlow(ScreenState.Initial)
    val state: MutableStateFlow<ScreenState> = _state

    init {
        networkHelper.startMonitoring()
    }

    fun loadWordDescription(inputText: String) {
        _state.value = ScreenState.Loading
        viewModelScope.launch {
            if (inputText.isNotEmpty()) {
                val listOfWords = getWordsUseCase.invoke(inputText)
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

    override fun onCleared() {
        super.onCleared()
        networkHelper.stopMonitoring()
    }
}