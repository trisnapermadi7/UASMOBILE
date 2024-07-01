package com.example.testuas.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.testuas.data.model.User
import com.example.testuas.data.repository.UserRepository
import com.example.testuas.presentation.screen.RegisterScreen
import com.example.testuas.ui.theme.TestUasTheme

/**
 * Activity responsible for user registration.
 */
class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use Compose for UI
        setContent {
            TestUasTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    RegisterScreen { name, email, password, confirmPassword ->
                        // Callback invoked when user attempts to register
                        when {
                            name.isEmpty() -> showToast("Name is required")
                            email.isEmpty() -> showToast("Email is required")
                            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> showToast("Please enter a valid email address")
                            password.isEmpty() -> showToast("Password is required")
                            confirmPassword.isEmpty() -> showToast("Confirm your password")
                            password != confirmPassword -> showToast("Passwords do not match")
                            else -> {
                                val newUser = User(name, email, password)

                                // Attempt to register the user using UserRepository
                                if (UserRepository.registerUser(newUser)) {
                                    showSuccessToast("Registered successfully")

                                    // Navigate to LoginActivity after successful registration
                                    navigateToLoginActivity()
                                } else {
                                    showToast("User already exists")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Displays a toast message.
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays a success toast message.
     */
    private fun showSuccessToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Navigates to the login activity.
     */
    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
