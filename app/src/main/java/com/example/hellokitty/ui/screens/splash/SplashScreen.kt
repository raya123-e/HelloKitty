package com.example.hellokitty.ui.screens.splash

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_REGISTER
import com.example.hellokitty.ui.theme.Cyan
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()
    var visible by remember { mutableStateOf(false) }

    // Play a soft meow sound on splash start
    LaunchedEffect(true) {
        MediaPlayer.create(context, R.raw.meow).start()
        visible = true
        delay(3000)
        navController.navigate(ROUT_REGISTER)
    }

    // UI
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Cyan),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splashhh),
                    contentDescription = "Hello Kitty Splash",
                    modifier = Modifier.size(300.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Hello Kitty Adoptions",
                    fontSize = 40.sp,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B3F00)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Every kitty deserves a loving home 🐾",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray
                )
            }
        }
    }
}
