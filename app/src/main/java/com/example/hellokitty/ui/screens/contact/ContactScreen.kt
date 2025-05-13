package com.example.hellokitty.ui.screens.contact

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.navigation.ROUT_ABOUT
import com.example.hellokitty.navigation.ROUT_DASHBOARD
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {
    val context = LocalContext.current
    var selectedIndex by remember { mutableStateOf(2) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Contact Us 💖",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Cyan) {
                listOf("Home" to Icons.Default.Home).forEachIndexed { index, (label, icon) ->
                    val isSelected = selectedIndex == index
                    val tint by animateColorAsState(if (isSelected) Color.Black else Color.DarkGray)

                    NavigationBarItem(
                        icon = { Icon(icon, contentDescription = label, tint = tint) },
                        label = { Text(label) },
                        selected = isSelected,
                        onClick = {
                            selectedIndex = index
                            if (index == 0) navController.navigate(ROUT_DASHBOARD)
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
                text = "✨ We'd love to hear from you!",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            ContactSectionHeader("Reach Us At")

            ContactCard(
                title = "📍 Location",
                detail = "Hello Kitty HQ\nNairobi, Kenya",
                onClick = {
                    val uri = Uri.parse("geo:0,0?q=Hello+Kitty+HQ,+Nairobi")
                    context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            )

            ContactCard(
                title = "📞 Phone",
                detail = "+254 712 345 678",
                onClick = {
                    val uri = Uri.parse("tel:+254712345678")
                    context.startActivity(Intent(Intent.ACTION_DIAL, uri))
                }
            )

            ContactCard(
                title = "✉️ Email",
                detail = "adopt@hellokittycats.com",
                onClick = {
                    val uri = Uri.parse("mailto:adopt@hellokittycats.com")
                    context.startActivity(Intent(Intent.ACTION_SENDTO, uri))
                }
            )

            ContactSectionHeader("Why Reach Out?")

            ContactCard(
                title = "🐾 Ask About Cats",
                detail = "Need help picking a kitty that fits your vibe? We got you.",
                onClick = {   val uri = Uri.parse("https://www.petfinder.com/help-center/chat/")
                    context.startActivity(Intent(Intent.ACTION_VIEW, uri)) }
            )

            ContactCard(
                title = "📆 Schedule A Visit",
                detail = "Come snuggle with fluffballs IRL.",
                onClick = { navController.navigate(ROUT_ABOUT) }
            )
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
fun ContactCard(title: String, detail: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .shadow(8.dp, RoundedCornerShape(18.dp)),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF9F6),
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
