package com.example.testuas.presentation.screen

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testuas.R
import com.example.testuas.presentation.auth.LoginActivity
import com.example.testuas.presentation.auth.RegisterActivity

// Composable function for the welcome screen
@Composable
fun WelcomeScreen(activity: ComponentActivity) {
    // Box to set the background gradient
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0080FF),
                        Color(0xFF0080FF)
                    )
                )
            )
    ) {
        // Checking the screen orientation
        val isPortrait = maxWidth < maxHeight
        if (isPortrait) {
            PortraitWelcomeLayout(activity)
        } else {
            LandscapeWelcomeLayout(activity)
        }
    }
}

// Portrait layout for the welcome screen
@Composable
fun PortraitWelcomeLayout(activity: ComponentActivity) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Application logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Illustration",
            modifier = Modifier
                .size(300.dp)
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )

        // Title for the welcome screen
        Text(
            text = "Stay Informed",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6200EA),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // Description text for the welcome screen
        Text(
            text = "Get the latest news and updates, tailored for you.",
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp)
        )

        // Row for buttons (Register and Login)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Button to navigate to RegisterActivity
            Button(
                onClick = {
                    val intent = Intent(activity, RegisterActivity::class.java)
                    activity.startActivity(intent)
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF6200EA))
            ) {
                Text("Register", color = Color.White, fontSize = 16.sp)
            }

            // Spacer between buttons
            Spacer(modifier = Modifier.width(16.dp))

            // Button to navigate to LoginActivity
            Button(
                onClick = {
                    val intent = Intent(activity, LoginActivity::class.java)
                    activity.startActivity(intent)
                },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text("Login", color = Color(0xFF6200EA), fontSize = 16.sp)
            }
        }
    }
}

// Landscape layout for the welcome screen
@Composable
fun LandscapeWelcomeLayout(activity: ComponentActivity) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
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
                .padding(end = 16.dp)
        ) {
            // Application logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Illustration",
                modifier = Modifier
                    .size(250.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(16.dp),
                contentScale = ContentScale.Crop
            )
        }

        // Right column for content in landscape mode
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(1f)
        ) {
            // Title for the welcome screen
            Text(
                text = "Stay Informed",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EA),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Description text for the welcome screen
            Text(
                text = "Get the latest news and updates, tailored for you.",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .padding(top = 8.dp, bottom = 16.dp) // Add spacing above and below
            )

            // Row for buttons (Register and Login)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Button to navigate to RegisterActivity
                Button(
                    onClick = {
                        val intent = Intent(activity, RegisterActivity::class.java)
                        activity.startActivity(intent)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF6200EA))
                ) {
                    Text("Register", color = Color.White, fontSize = 16.sp)
                }

                // Spacer between buttons
                Spacer(modifier = Modifier.width(16.dp))

                // Button to navigate to LoginActivity
                Button(
                    onClick = {
                        val intent = Intent(activity, LoginActivity::class.java)
                        activity.startActivity(intent)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                    Text("Login", color = Color(0xFF6200EA), fontSize = 16.sp)
                }
            }
        }
    }
}
