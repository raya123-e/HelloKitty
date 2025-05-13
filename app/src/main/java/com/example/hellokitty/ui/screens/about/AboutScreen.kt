package com.example.hellokitty.ui.screens.about

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_DASHBOARD
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }
    val mContext = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Welcome to Hello Kitty Adoption") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_DASHBOARD) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF4BBA7),
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFF4BBA7)) {
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
                    .verticalScroll(rememberScrollState())
            ) {
                // Header Image
                Image(
                    painter = painterResource(R.drawable.img_54), // Replace with Hello Kitty-themed image
                    contentDescription = "Hello Kitty Adoption",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Adopt a Kitty Today! 🐾",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF8B5E83),
                    modifier = Modifier.fillMaxWidth(),

                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Meet Our Featured Cats Looking for Their Furever Homes",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Cursive,
                    color = Color(0xFF8B5E83),
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Search Bar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    leadingIcon = { Icon(painter = painterResource(R.drawable.pets), contentDescription = "") },
                    placeholder = { Text(text = "Search for a kitty...") },
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Featured Cats Row
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_17), // Replace with Hello Kitty-themed image
                        contentDescription = "Featured Cat 1",
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "Fluffy",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF8B5E83)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Fluffy is looking for a forever home! She's sweet, playful, and loves attention. Adopt her today and make your home complete.",
                            fontSize = 12.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0720245837".toUri()
                                mContext.startActivity(callIntent)

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4BBA7)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                        ) {
                            Text(
                                text = "Call to Adopt",
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Another Featured Cat Row
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_18), // Replace with Hello Kitty-themed image
                        contentDescription = "Featured Cat 2",
                        modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillWidth
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "Whiskers",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF8B5E83)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Whiskers is a curious kitty who loves exploring! She’s ready for her new home and to share her adventures with you.",
                            fontSize = 12.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                val callIntent = Intent(Intent.ACTION_DIAL)
                                callIntent.data = "tel:0117434950".toUri()
                                mContext.startActivity(callIntent)

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4BBA7)),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                        ) {
                            Text(
                                text = "Call to Adopt",
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
    )
}




@Preview(showBackground = true)
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())

}

