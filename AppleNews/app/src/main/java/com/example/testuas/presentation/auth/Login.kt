package com.example.testuas.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.testuas.data.repository.UserRepository
import com.example.testuas.presentation.screen.LoginScreen
import com.example.testuas.ui.theme.TestUasTheme
import com.example.testuas.presentation.detail.MainActivity

/**
 * Activity responsible for handling user login.
 */
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use Compose for UI
        setContent {
            TestUasTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen { email, password ->
                        // Callback invoked when user attempts to log in
                        if (UserRepository.loginUser(email, password)) {
                            navigateToMainActivity()
                        } else {
                            showInvalidCredentialsToast()
                        }
                    }
                }
            }
        }
    }

    /**
     * Navigates to the main activity upon successful login.
     */
    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * Displays a toast message indicating invalid login credentials.
     */
    private fun showInvalidCredentialsToast() {
        Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
    }
}
