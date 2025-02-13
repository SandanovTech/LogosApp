package com.example.logosapp.presentation

import androidx.lifecycle.ViewModel
import com.example.logosapp.domain.usecases.GetLogosUseCase

class MainViewModel(
    private val getLogosUseCase: GetLogosUseCase
) : ViewModel() {

}