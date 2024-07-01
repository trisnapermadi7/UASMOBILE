package com.example.testuas.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.testuas.presentation.screen.WelcomeScreen
import com.example.testuas.ui.theme.TestUasTheme

/**
 * Activity displaying the welcome screen.
 */
class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity using Jetpack Compose
        setContent {
            TestUasTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    WelcomeScreen(this)
                }
            }
        }
    }
}
