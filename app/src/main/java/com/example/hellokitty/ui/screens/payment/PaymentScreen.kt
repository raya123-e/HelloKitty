package com.example.hellokitty.ui.screens.payment

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_CARD
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.navigation.ROUT_MPESA
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentScreen(navController: NavController) {
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Payment", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
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
                        navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", tint = Color.Black) },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.img_33),
                    contentDescription = "Hello Kitty Background",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "You're about to adopt:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.cat_placeholder), // Swap this for real cat image
                            contentDescription = "Adopted Cat",
                            modifier = Modifier.size(80.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text("Name: Mr. Fluffy", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Breed: Persian", fontSize = 16.sp)
                            Text("Adoption Fee: KES 2,500", fontSize = 16.sp, color = Color.Gray)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Choose Your Payment Method",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                PaymentButton(
                    label = "M-Pesa",
                    onClick = {
                        Toast.makeText(context, "Redirecting to M-Pesa payment for Mr. Fluffy", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUT_MPESA)
                    },
                    icon = painterResource(R.drawable.mpesa_logo)
                )

                Spacer(modifier = Modifier.height(20.dp))

                PaymentButton(
                    label = "Visa",
                    onClick = {
                        Toast.makeText(context, "Redirecting to Visa payment for Mr. Fluffy", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUT_CARD)
                    },
                    icon = painterResource(R.drawable.img_34)
                )
            }
        }
    )
}

@Composable
fun PaymentButton(label: String, onClick: () -> Unit, icon: Painter) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF4BBA7)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = icon,
                contentDescription = "$label Icon",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(navController = rememberNavController())
}
