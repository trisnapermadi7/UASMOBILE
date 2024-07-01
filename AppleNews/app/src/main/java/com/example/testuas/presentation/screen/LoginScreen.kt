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

@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
    // Mutable state variables for email and password fields
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Background gradient based on primary and secondary colors
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
        // Determine layout based on screen orientation
        val isPortrait = maxWidth < maxHeight

        if (isPortrait) {
            // Portrait layout
            PortraitLayout(email, password, { newEmail, newPassword ->
                email = newEmail
                password = newPassword
            }, onLogin)
        } else {
            // Landscape layout
            LandscapeLayout(email, password, { newEmail, newPassword ->
                email = newEmail
                password = newPassword
            }, onLogin)
        }
    }
}

@Composable
fun PortraitLayout(
    email: String,
    password: String,
    onValueChange: (String, String) -> Unit,
    onLogin: (String, String) -> Unit
) {
    // Column layout for portrait mode
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // App logo image
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 32.dp),
            contentScale = ContentScale.Crop
        )

        // Title text
        Text(
            text = "Welcome Back!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email input field
        TextField(
            value = email,
            onValueChange = { onValueChange(it, password) },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password input field
        TextField(
            value = password,
            onValueChange = { onValueChange(email, it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login button
        Button(
            onClick = { onLogin(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
        ) {
            Text("Login", color = Color.White)
        }
    }
}

@Composable
fun LandscapeLayout(
    email: String,
    password: String,
    onValueChange: (String, String) -> Unit,
    onLogin: (String, String) -> Unit
) {
    // Row layout for landscape mode
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Left column for logo
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            // App logo image
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 32.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Right column for login form
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
        ) {
            // Title text
            Text(
                text = "Welcome Back!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Email input field
            TextField(
                value = email,
                onValueChange = { onValueChange(it, password) },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Password input field
            TextField(
                value = password,
                onValueChange = { onValueChange(email, it) },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Login button
            Button(
                onClick = { onLogin(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
            ) {
                Text("Login", color = Color.White)
            }
        }
    }
}

