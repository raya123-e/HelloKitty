package com.example.hellokitty.ui.screens.mpesa

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_DASHBOARD
import com.example.hellokitty.navigation.ROUT_PAYMENT
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MpesaScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val mContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("M-Pesa", color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_PAYMENT) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },

        bottomBar = {
            NavigationBar(containerColor = Cyan) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_DASHBOARD)
                    }
                )

            }
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFFF4BBA7),
                                Color(0xFFFCE4EC),
                                Color(0xFFF8BBD0)
                            )
                        )
                    )
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Logo/Header
                Image(
                    painter = painterResource(R.drawable.hello_kitty_logo), // Replace with your actual Hello Kitty logo
                    contentDescription = "Hello Kitty Logo",
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "Payment Purr-fection",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF641B80),
                    fontFamily = FontFamily.Serif
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Choose your payment method",
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val stkIntent = mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        if (stkIntent != null) {
                            mContext.startActivity(stkIntent)
                        } else {
                            Toast.makeText(mContext, "STK not available on this device 😿", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFECB3)),
                    shape = RoundedCornerShape(32.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(60.dp)
                ) {
                    Text(
                        text = "Pay with M-PESA",
                        color = Color(0xFF1B5E20),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        navController.navigate(ROUT_DASHBOARD)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8A65)),
                    shape = RoundedCornerShape(32.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(60.dp)
                ) {
                    Text(
                        text = "🐾 Pawceed to Adoption",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MpesaScreenPreview() {
    MpesaScreen(navController = rememberNavController())
}
