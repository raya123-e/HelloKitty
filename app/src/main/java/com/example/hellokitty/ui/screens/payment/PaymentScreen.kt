@file:Suppress("UNUSED_EXPRESSION")

package com.example.hellokitty.ui.screens.payment

import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_CARD
import com.example.hellokitty.navigation.ROUT_DASHBOARD
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.navigation.ROUT_MPESA
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Payment",
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF4BBA7))
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFF4BBA7)) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_DASHBOARD)
                    }
                )

            }
        },
        containerColor = Color.Transparent,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFE4EC), // light baby pink
                                Color(0xFFF8BBD0), // blossom blush
                                Color(0xFFF4BBA7)  // base theme
                            )
                        )
                    )
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(tween(1000)) + slideInVertically(tween(1000)),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_33),
                            contentDescription = "Hello Kitty Header",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Choose Your Payment Method",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF4B2E83),
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .alpha(0.95f)
                    )

                    AnimatedPaymentButton(
                        label = "M-Pesa",
                        onClick = {
                            Toast.makeText(context, "Redirecting to M-Pesa", Toast.LENGTH_SHORT).show()
                            navController.navigate(ROUT_MPESA)
                        },
                        icon = painterResource(R.drawable.mpesa_logo)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    AnimatedPaymentButton(
                        label = "Visa",
                        onClick = {
                            Toast.makeText(context, "Redirecting to Visa", Toast.LENGTH_SHORT).show()
                            navController.navigate(ROUT_CARD)
                        },
                        icon = painterResource(R.drawable.img_34)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "💖 By adopting Mr. Fluffy, you're not just gaining a bestie — you're giving a home to a soul who just wants to nap in a sunbeam. All cats are vet-checked, vaccinated, and come with a starter kit: cozy blanket, food, and a toy mouse for ultimate zoomies.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.DarkGray,
                        lineHeight = 22.sp,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .alpha(0.9f)
                    )
                }
            }
        }
    )
}

@Composable
fun AnimatedPaymentButton(label: String, onClick: () -> Unit, icon: Painter) {
    var pressed by remember { mutableStateOf(false) }

    LaunchedEffect(pressed) {
        if (pressed) {
            delay(80L)
            pressed = false
        }
    }

    val scale = animateFloatAsState(targetValue = if (pressed) 0.97f else 1f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .scale(scale.value)
            .clickable {
                pressed = true
                onClick()
            },
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDE0DC)),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = icon,
                contentDescription = "$label Icon",
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = label,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(navController = rememberNavController())
}
