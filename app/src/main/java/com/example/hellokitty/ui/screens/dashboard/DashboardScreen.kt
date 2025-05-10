package com.example.hellokitty.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_ABOUT
import com.example.hellokitty.navigation.ROUT_CONTACT
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.navigation.ROUT_PAYMENT
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,
                drawerShape = RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Navigation",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8B5E83) // Elegant lavender shade
                )
                NavigationDrawerItem(label = { Text("Home") }, selected = false, onClick = {
                    coroutineScope.launch { drawerState.close() }
                    navController.navigate(ROUT_HOME)
                })
                NavigationDrawerItem(label = { Text("About") }, selected = false, onClick = {
                    coroutineScope.launch { drawerState.close() }
                    navController.navigate(ROUT_ABOUT)
                })
                NavigationDrawerItem(label = { Text("Contact") }, selected = false, onClick = {
                    coroutineScope.launch { drawerState.close() }
                    navController.navigate(ROUT_CONTACT)
                })
                NavigationDrawerItem(label = { Text("Payment") }, selected = false, onClick = {
                    coroutineScope.launch { drawerState.close() }
                    navController.navigate(ROUT_PAYMENT)
                })
            }
        }
    ) {
        Scaffold(
            containerColor = Color(0xFFF8F1E7) // Soft, warm cream for the background
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFF8F1E7)) // Elegant neutral background
            ) {
                // Hero Section: Eye-catching intro before the first row
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color(0xFFEDD6D6), Color(0xFFF8F1E7))
                            )
                        )
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_29), // Add your icon here
                            contentDescription = "Welcome Cat",
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Your Purrfect Companion Awaits 🐱",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A3C3A),
                            fontFamily = FontFamily.Cursive
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Give a cat a home, and they'll give you their heart.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { navController.navigate(ROUT_HOME) },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5E83))
                        ) {
                            Text(text = "Adopt Now", fontSize = 16.sp, color = Color.White)
                        }
                    }
                }

                // Elegant Card at the top
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(24.dp), // Rounded corners for a chic look
                    elevation = cardElevation(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF2D1D1)) // Subtle pastel pink
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Adopt, Don't Shop",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A3C3A),
                            fontFamily = FontFamily.Cursive // Elegant, playful font
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Every cat deserves a cozy forever home.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Fast Adoption | Health Guaranteed | Loving Companions 🐾",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF9E6A6A)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // First Row: Home and About Navigation
                Row(modifier = Modifier.padding(start = 30.dp, end = 16.dp)) {
                    NavigationCard("Home", R.drawable.img_40) {
                        navController.navigate(ROUT_HOME)
                    }
                    Spacer(modifier = Modifier.width(16.dp).padding(start = 30.dp, end = 16.dp))
                    NavigationCard("About", R.drawable.img_41) {
                        navController.navigate(ROUT_ABOUT)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Second Row: Contact Us and Payment Navigation
                Row(modifier = Modifier.padding(start = 30.dp, end = 16.dp)) {
                    NavigationCard("Contact Us", R.drawable.img_42) {
                        navController.navigate(ROUT_CONTACT)
                    }
                    Spacer(modifier = Modifier.width(16.dp).padding(start = 30.dp, end = 16.dp))
                    NavigationCard("Payment", R.drawable.img_43) {
                        navController.navigate(ROUT_PAYMENT)
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationCard(label: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(180.dp)
            .padding(end = 16.dp, start = 16.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        elevation = cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFBE4E4)) // Soft blush color
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = label,
                modifier = Modifier.size(100.dp) // Keep the image size balanced
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                fontSize = 18.sp,
                color = Color(0xFF4A3C3A),
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Serif // Adding a touch of elegance with serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(rememberNavController())
}
