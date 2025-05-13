package com.example.hellokitty.ui.screens.cats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
fun WirehairScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("American Wirehair", fontWeight = FontWeight.SemiBold, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
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
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_31),
                    contentDescription = "American Wirehair",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    contentScale = ContentScale.Crop
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(30.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "American Wirehair",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                fontFamily = FontFamily.Serif
                            )
                            Text(
                                text = "$50",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF69B4) // hot pink chic
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                            WirehairInfoCard(title = "Age", value = "1.2 yrs")
                            WirehairInfoCard(title = "Sex", value = "Male")
                            WirehairInfoCard(title = "Color", value = "Orange")
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "The American Wirehair is a rare and quirky sweetheart known for its crimped coat and crinkly whiskers. Originating from New York, this breed is playful, gentle, and deeply affectionate. Great with families and thrives in calm indoor environments.",
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Adoption Notes:\n• Vet checked\n• Vaccinated\n• Spayed/neutered\n• Includes starter pack (food + toys)",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { navController.navigate(ROUT_PAYMENT) },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4BBA7)),
                            shape = RoundedCornerShape(50),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_29),
                                contentDescription = "Adopt Icon",
                                modifier = Modifier.size(40.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(text = "Adopt Now", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun WirehairInfoCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Cyan),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, fontSize = 16.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WirehairScreenPreview() {
    WirehairScreen(navController = rememberNavController())
}
