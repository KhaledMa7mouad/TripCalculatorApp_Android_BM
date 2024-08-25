package com.example.trip_calculator_internship_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.trip_calculator_internship_android.ui.theme.Trip_Calculator_internship_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Trip_Calculator_internship_androidTheme {
                AppNavHost()
            }
        }
    }
}

