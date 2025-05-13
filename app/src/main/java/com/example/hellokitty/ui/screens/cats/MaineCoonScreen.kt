package com.example.hellokitty.ui.screens.cats

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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
fun MaineCoonScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    var isFavorite by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Adopt Me: Maine Coon", color = Color.Black) },
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
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Gallery
            Text("Photo Gallery", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(R.drawable.mainecoon, R.drawable.img_30, R.drawable.img_38).forEach {
                    Image(
                        painter = painterResource(it),
                        contentDescription = "Gallery Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Main Info Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(30.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "MaineCoon Cat",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "$500", fontSize = 24.sp, color = Color.Magenta)
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Info Cards
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        InfoCard("Age", "0.9yrs")
                        InfoCard("Sex", "Female")
                        InfoCard("Color", "Mixed")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description
                    Text(
                        text = "The Maine Coon is a large and social cat, commonly referred to as \"the gentle giant.\" Known for its size, fluff, and dog-like charm, it thrives in loving homes. Think of her as the cuddly roommate who purrs instead of paying rent.",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Adoption Details
                    Text(
                        text = "• Vaccinated: ✅ Yes\n• Temperament: 🐾 Affectionate, Playful\n• Good with Kids: 👶 Yes\n• Good with Other Cats: 🐱 Yes",
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Foster Info
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(Cyan),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.img_39),
                                contentDescription = "Foster",
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text("Foster Parent: Lily Chen", fontWeight = FontWeight.Bold, color = Color.Black)
                                Text("Contact: lily.chen@email.com", fontSize = 14.sp, color = Color.DarkGray)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Testimonial
                    Text(
                        text = "\"Misty is a total sweetheart. She's calm, cuddly, and loves curling up on the windowsill. She's ready for her forever home!\" — Lily",
                        fontStyle = FontStyle.Italic,
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Adopt Now Button
                    Button(
                        onClick = { navController.navigate(ROUT_PAYMENT) },
                        colors = ButtonDefaults.buttonColors(Color(0xFFF4BBA7)),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier.fillMaxWidth().height(60.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.img_29),
                            contentDescription = "Adopt",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Unspecified
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("Adopt Now", fontSize = 20.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}

@Composable
fun InfoCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .padding(4.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Cyan),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, fontSize = 18.sp, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, fontSize = 16.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MaineCoonScreenPreview() {
    MaineCoonScreen(navController = rememberNavController())
}
