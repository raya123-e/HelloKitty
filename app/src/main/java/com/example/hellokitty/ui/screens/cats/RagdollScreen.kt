package com.example.hellokitty.ui.screens.cats

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun RagdollScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ragdoll", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Cyan)
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
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.ragdoll),
                        contentDescription = "Ragdoll Cat",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 240.dp)
                            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Ragdoll Cat",
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = "$80",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFF69B4)
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                DetailCard("Age", "0.5 yrs")
                                DetailCard("Sex", "Male")
                                DetailCard("Color", "Brown")
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Text(
                                text = "About Me",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Ragdolls are plushy companions with soft fur, soulful eyes, and a dog-like loyalty. They’re chill, affectionate, and basically emotional support in cat form. The vibe? Soft, fluffy, and emotionally available.",
                                fontSize = 16.sp,
                                color = Color.DarkGray,
                                textAlign = TextAlign.Justify,
                                lineHeight = 22.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = { navController.navigate(ROUT_PAYMENT) },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4BBA7)),
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                            ) {
                                Text(
                                    text = "Adopt Me",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun RagdollDetailCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F7FA)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, color = Color(0xFFEC407A), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = value, color = Color.Black, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RagdollScreenPreview() {
    RagdollScreen(navController = rememberNavController())
}
