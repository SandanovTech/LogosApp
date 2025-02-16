package com.example.logosapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import com.example.logosapp.presentation.MainViewModel
import com.example.logosapp.presentation.screenState.ScreenState
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun InputScreen() {
    val viewModel: MainViewModel = koinViewModel<MainViewModel>()
    val state = viewModel.state.collectAsState()
    val inputText = rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = inputText.value, onValueChange = {
            inputText.value = it
        })
        Button(onClick = {
            viewModel.loadWordDescription(inputText.value)
        }) {
            Text("Get info")
        }
        when (val currentValue = state.value) {
            is ScreenState.Error -> {
                Text("Input incorrect")
            }
            is ScreenState.Success -> {
                currentValue.words.map { word ->
                    Text(word.name)
                    Text(word.ticker)
                    AsyncImage(
                        model = word.image,
                        contentDescription = "Logo"
                    )
                }
            }
            ScreenState.Loading -> {
                CircularProgressIndicator()
            }
            ScreenState.Initial -> {
                Text("Input name crypto")
            }
        }
    }
}