package com.example.hellokitty.ui.screens.contact

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun ContactScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(2) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Get in Touch",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Cyan) {
                listOf("Home" to Icons.Default.Home, "Favorites" to Icons.Default.Favorite, "Profile" to Icons.Default.Person).forEachIndexed { index, (label, icon) ->
                    val isSelected = selectedIndex == index
                    val tint by animateColorAsState(if (isSelected) Color.Black else Color.DarkGray)

                    NavigationBarItem(
                        icon = { Icon(icon, contentDescription = label, tint = tint) },
                        label = { Text(label) },
                        selected = isSelected,
                        onClick = {
                            selectedIndex = index
                            if (index == 0) navController.navigate(ROUT_HOME)
                            // Add more navigation logic here
                        }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFFFF1F4), Color(0xFFFFE3EB))
                    )
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "💌 We'd love to hear from you!",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            ContactSectionHeader("Reach Us At")

            ContactCard("📍 Location", "Hello Kitty HQ\nNairobi, Kenya")
            ContactCard("📞 Phone", "+254 712 345 678")
            ContactCard("✉️ Email", "adopt@hellokittycats.com")

            ContactSectionHeader("Why Reach Out?")

            ContactCard("🐾 Ask About Cats", "Need help picking a kitty that fits your vibe? We got you.")
            ContactCard("📆 Schedule A Visit", "Come snuggle with fluffballs IRL.")
        }
    }
}

@Composable
fun ContactSectionHeader(title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = Cyan,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun ContactCard(title: String, detail: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF9F6),
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = detail, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    ContactScreen(navController = rememberNavController())
}
