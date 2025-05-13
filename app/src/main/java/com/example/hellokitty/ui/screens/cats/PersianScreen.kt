package com.example.hellokitty.ui.screens.cats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.navigation.ROUT_PAYMENT
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersianScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Persian Cat", color = Color.White, fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFC6E2)
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFFFC6E2)) {
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
        containerColor = Color.Transparent,
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color(0xFFF7E4FF), Color(0xFFF2C1F3))
                        )
                    )
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_21),
                    contentDescription = "Persian Cat",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Persian Cat",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF333333)
                            )
                            Text(
                                text = "$100",
                                fontSize = 24.sp,
                                color = Color(0xFFD81B60),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            AttributeCard(label = "Age", value = "1")
                            AttributeCard(label = "Sex", value = "Female")
                            AttributeCard(label = "Color", value = "White")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "The Persian cat, also known as the Persian Longhair, is a long-haired breed of cat characterized by a round face and short muzzle. Persian cats were ranked as one of the most popular cat breeds worldwide.",
                            fontSize = 16.sp,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            onClick = { navController.navigate(ROUT_PAYMENT) },
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFD4EC)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img_29),
                                contentDescription = "Cart Icon",
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Adopt Now",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun AttributeCard(label: String, value: String) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, color = Color(0xFFEC407A), fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = value, color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersianScreenPreview() {
    PersianScreen(navController = rememberNavController())
}
