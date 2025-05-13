package com.example.hellokitty.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_DASHBOARD
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.navigation.ROUT_REGISTER
import com.example.hellokitty.navigation.ROUT_START
import com.example.hellokitty.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Observe login logic
    LaunchedEffect(authViewModel) {
        authViewModel.loggedInUser = { user ->
            if (user == null) {
                Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            } else {
                if (user.role == "admin") {
                    navController.navigate(ROUT_DASHBOARD)
                } else {
                    navController.navigate(ROUT_START)
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .paint(painter = painterResource(R.drawable.img_56), contentScale = ContentScale.FillBounds)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShimmerHelloKittyLogo()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Welcome Back, Cat Lover!",
            fontSize = 36.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.85f)),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", color = Color.Black) },
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", color = Color.Black) },
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff
                                ),
                                contentDescription = if (passwordVisible) "Hide Password" else "Show Password"
                            )
                        }
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFF4BBA7), Color(0xFFFFA5A5))
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = {
                            if (email.isBlank() || password.isBlank()) {
                                Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                            } else {
                                authViewModel.loginUser(email, password)
                            }
                        },
                        modifier = Modifier.fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Login", color = Color.White)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate(ROUT_REGISTER) }) {
            Text("Don't have an account? Register", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(visible = true, enter = fadeIn(), exit = fadeOut()) {
            Text(
                text = "✨ Did you know? Cats sleep for 70% of their lives.",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun ShimmerHelloKittyLogo() {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = TweenSpec(durationMillis = 1500),
            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(id = R.drawable.hello_kitty_logo),
        contentDescription = "Hello Kitty Logo",
        modifier = Modifier
            .size(120.dp)
            .graphicsLayer { this.alpha = alpha }
    )
}
