package com.example.hellokitty.ui.screens.auth

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.hellokitty.R
import com.example.hellokitty.model.User
import com.example.hellokitty.navigation.ROUT_LOGIN
import com.example.hellokitty.ui.theme.Cyan
import com.example.hellokitty.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    navController: NavController,
    onRegisterSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var receiveUpdates by remember { mutableStateOf(true) }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var role by remember { mutableStateOf("User") }
    val roleOptions = listOf("User", "Admin")
    var roleExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val shimmerAlpha by rememberInfiniteTransition().animateFloat(
        initialValue = 0.3f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.img_18),
                contentScale = ContentScale.Crop
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Sign Up for Purrfection 🐱",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = Color.White,
            modifier = Modifier.alpha(shimmerAlpha)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username", color = Color.Black) },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.Black) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email" , color = Color.Black) },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null, tint = Color.Black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        ExposedDropdownMenuBox(
            expanded = roleExpanded,
            onExpandedChange = { roleExpanded = !roleExpanded }
        ) {
            OutlinedTextField(
                value = role,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select Role", color = Color.Black) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = roleExpanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = roleExpanded,
                onDismissRequest = { roleExpanded = false }
            ) {
                roleOptions.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            role = selectionOption
                            roleExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.Black) },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff
                        ),
                        contentDescription = null, tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password", color = Color.Black) },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (confirmPasswordVisible) R.drawable.visibility else R.drawable.visibilityoff
                        ),
                        contentDescription = null, tint = Color.Black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(checked = receiveUpdates, onCheckedChange = { receiveUpdates = it })
            Text("I want to receive updates on adoptable cats 🐾", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color(0xFFF4BBA7), Color(0xFFFFC1CC))
                    ),
                    shape = MaterialTheme.shapes.large
                ),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        Toast.makeText(context, "All fields are required", Toast.LENGTH_SHORT).show()
                    } else if (password != confirmPassword) {
                        Toast.makeText(context, "Passwords don't match, love 💔", Toast.LENGTH_SHORT).show()
                    } else {
                        authViewModel.registerUser(
                            User(username = username, email = email, role = role, password = password)
                        )
                        onRegisterSuccess()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Register Meow", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { navController.navigate(ROUT_LOGIN) }) {
            Text("Already have an account? Login", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))
    }
}
