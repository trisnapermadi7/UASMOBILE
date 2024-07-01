package com.example.testuas.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testuas.R

// Composable function for the registration screen
@Composable
fun RegisterScreen(onRegister: (String, String, String, String) -> Unit) {
    // State variables to hold input field values
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    // Box to set the background gradient
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
    ) {
        // Checking the screen orientation
        val isPortrait = maxWidth < maxHeight

        if (isPortrait) {
            // Portrait layout for the registration screen
            PortraitRegisterLayout(name, email, password, confirmPassword, { newName, newEmail, newPassword, newConfirmPassword ->
                name = newName
                email = newEmail
                password = newPassword
                confirmPassword = newConfirmPassword
            }, onRegister)
        } else {
            // Landscape layout for the registration screen
            LandscapeRegisterLayout(name, email, password, confirmPassword, { newName, newEmail, newPassword, newConfirmPassword ->
                name = newName
                email = newEmail
                password = newPassword
                confirmPassword = newConfirmPassword
            }, onRegister)
        }
    }
}

// Portrait layout for the registration screen
@Composable
fun PortraitRegisterLayout(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    onValueChange: (String, String, String, String) -> Unit,
    onRegister: (String, String, String, String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Application logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 32.dp),
            contentScale = ContentScale.Crop
        )

        // Title for creating a new account
        Text(
            text = "Create an Account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input field for full name
        TextField(
            value = name,
            onValueChange = { onValueChange(it, email, password, confirmPassword) },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Input field for email
        TextField(
            value = email,
            onValueChange = { onValueChange(name, it, password, confirmPassword) },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Input field for password
        TextField(
            value = password,
            onValueChange = { onValueChange(name, email, it, confirmPassword) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Input field for confirming password
        TextField(
            value = confirmPassword,
            onValueChange = { onValueChange(name, email, password, it) },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to perform registration
        Button(
            onClick = { onRegister(name, email, password, confirmPassword) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Text("Register", color = Color.White)
        }
    }
}

// Landscape layout for the registration screen
@Composable
fun LandscapeRegisterLayout(
    name: String,
    email: String,
    password: String,
    confirmPassword: String,
    onValueChange: (String, String, String, String) -> Unit,
    onRegister: (String, String, String, String) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Left column for logo in landscape mode
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            // Application logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 32.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Right column for registration fields in landscape mode
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            // Title for creating a new account
            Text(
                text = "Create an Account",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Input field for full name
            TextField(
                value = name,
                onValueChange = { onValueChange(it, email, password, confirmPassword) },
                label = { Text("Full Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Input field for email
            TextField(
                value = email,
                onValueChange = { onValueChange(name, it, password, confirmPassword) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Input field for password
            TextField(
                value = password,
                onValueChange = { onValueChange(name, email, it, confirmPassword) },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Input field for confirming password
            TextField(
                value = confirmPassword,
                onValueChange = { onValueChange(name, email, password, it) },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to perform registration
            Button(
                onClick = { onRegister(name, email, password, confirmPassword) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}
