package com.example.hellokitty.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.example.hellokitty.navigation.*
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Hello Kitty Adoptions", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                            Text("East Africa, Kenya", fontSize = 14.sp, color = Color.DarkGray)
                        }
                        Image(
                            painter = painterResource(R.drawable.img_20),
                            contentDescription = "User Avatar",
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Cyan) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        // Handle Favorites Navigation
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        // Handle Profile Navigation
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
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Search cats...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan,
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Text(
                    text = "Featured Cats",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    val featuredPets = listOf(
                        Triple("Ragdoll", R.drawable.ragdoll, ROUT_RAGDOLL),
                        Triple("Persian", R.drawable.img_21, ROUT_PERSIAN),
                        Triple("Ragamuffin", R.drawable.img_23, ROUT_RAGAMUFFIN),
                        Triple("Wirehair", R.drawable.img_37, ROUT_WIREHAIR),
                        Triple("About", R.drawable.img_17, ROUT_MAINECOON)
                    )

                    items(featuredPets.size) { index ->
                        val (name, image, route) = featuredPets[index]
                        PetCard(petName = name, petImage = image, navController = navController, route = route)
                    }
                }

                Text(
                    text = "Cat Categories",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CategoryChip("Persian")
                    CategoryChip("Ragdoll")
                    CategoryChip("Ragamuffin")
                    CategoryChip("Wirehair")
                }

                Text(
                    text = "Adoption Tips",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    TipCard(
                        title = "Prepare Your Home",
                        description = "Ensure your space is safe and welcoming for your new cat."
                    )
                    TipCard(
                        title = "Visit the Vet",
                        description = "Schedule a health checkup as soon as you adopt."
                    )
                    TipCard(
                        title = "Get the Essentials",
                        description = "Food, bed, toys, and grooming supplies are must-haves."
                    )
                }
            }
        }
    )
}

@Composable
fun TipCard(title: String, description: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

@Composable
fun PetCard(petName: String, petImage: Int, navController: NavController, route: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                navController.navigate(route)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = petImage),
                contentDescription = petName,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = petName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun CategoryChip(categoryName: String) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable { },
        shape = RoundedCornerShape(20.dp),
        color = Cyan
    ) {
        Text(
            text = categoryName,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
