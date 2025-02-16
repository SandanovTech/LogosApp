package com.example.logosapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.logosapp.data.helper.NetworkHelper
import com.example.logosapp.presentation.screens.InputScreen
import com.example.logosapp.ui.theme.LogosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LogosAppTheme {
                InputScreen()
            }
        }
//        NetworkHelper(this).isWifiConnected(this)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        NetworkHelper(this).stopMonitoring()
//    }
}