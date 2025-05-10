package com.example.hellokitty.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        // Top Bar
        topBar = {
            TopAppBar(
                title = { Text("Dashboard", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
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

        // Bottom Bar
        bottomBar = {
            NavigationBar(
                containerColor = Cyan
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.Black) },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", tint = Color.Black) },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                    }
                )
            }
        },

        // FloatingActionButton (Optional)
        floatingActionButton = { },

        // Content
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Featured Cat of the Day
                FeaturedCatCard()

                // Adoption Stats
                AdoptionStatsSection()

                // Quick Actions
                QuickActionsSection(navController)
            }
        }
    )
}

@Composable
fun FeaturedCatCard() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Cyan)
            .padding(16.dp)
    ) {
        Text(
            text = "Featured Cat of the Day",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.img_17),
            contentDescription = "Featured Cat",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Meet Momo! She's a friendly Persian cat looking for a forever home.",
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

@Composable
fun AdoptionStatsSection() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Adoption Stats",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Cats Available for Adoption: 25",
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Recent Adoptions: 5",
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun QuickActionsSection(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalArrangement =(Arrangement.spacedBy(16.dp))
    ) {
        Button(
            onClick = { /* Navigate to favorites */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Cyan)
        ) {
            Text(text = "View Favorites", fontSize = 16.sp, color = Color.White)
        }

        Button(
            onClick = { /* Navigate to adoption tips */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Cyan)
        ) {
            Text(text = "Adoption Tips", fontSize = 16.sp, color = Color.White)
        }

        Button(
            onClick = { /* Start the adoption process */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Cyan)
        ) {
            Text(text = "Start Adoption", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}
