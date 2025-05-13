package com.example.hellokitty.ui.screens.card

import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
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

val PinkPaw = Color(0xFFF4BBA7)
val SoftCream = Color(0xFFFFF8F4)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(navController: NavController, catName: String = "Princess Whiskers", catBreed: String = "Persian", catFee: String = "$60.00") {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Adopt with Love 🐾") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_PAYMENT) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PinkPaw,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = PinkPaw) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
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
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .background(SoftCream)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("You're Almost There! 🐱", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = PinkPaw, fontFamily = FontFamily.Serif)
                Text("Get ready to welcome your new best friend.", fontSize = 16.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 16.dp))

                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.cat_placeholder),
                            contentDescription = "Adopted Cat",
                            modifier = Modifier.size(72.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text("Adopting: $catName", fontWeight = FontWeight.Bold)
                            Text("Breed: $catBreed", color = Color.Gray)
                            Text("Adoption Fee: $catFee", color = Color.Gray)
                        }
                    }
                }

                var name by remember { mutableStateOf("") }
                var cardNumber by remember { mutableStateOf("") }
                var expiry by remember { mutableStateOf("") }
                var cvv by remember { mutableStateOf("") }
                var saveCard by remember { mutableStateOf(false) }

                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Name on Card 🐱") }, shape = RoundedCornerShape(16.dp), colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = PinkPaw, cursorColor = PinkPaw), modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
                        OutlinedTextField(value = cardNumber, onValueChange = { cardNumber = it }, label = { Text("Card Number 💳") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(16.dp), colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = PinkPaw, cursorColor = PinkPaw), modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            OutlinedTextField(value = expiry, onValueChange = { expiry = it }, label = { Text("MM/YY") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(16.dp), colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = PinkPaw, cursorColor = PinkPaw), modifier = Modifier.weight(1f).padding(8.dp))
                            OutlinedTextField(value = cvv, onValueChange = { cvv = it }, label = { Text("CVV") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), shape = RoundedCornerShape(16.dp), colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = PinkPaw, cursorColor = PinkPaw), modifier = Modifier.weight(1f).padding(8.dp))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 12.dp)) {
                            Switch(checked = saveCard, onCheckedChange = { saveCard = it }, colors = SwitchDefaults.colors(checkedThumbColor = PinkPaw))
                            Text("Save for future paw-chases 🐾", fontSize = 14.sp, modifier = Modifier.padding(start = 8.dp))
                        }
                        Button(onClick = { /* Add payment logic */ }, colors = ButtonDefaults.buttonColors(containerColor = PinkPaw), shape = RoundedCornerShape(50.dp), modifier = Modifier.fillMaxWidth().padding(top = 24.dp)) {
                            Text("Confirm Adoption", fontSize = 18.sp, color = Color.White)
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardScreenPreview() {
    CardScreen(navController = rememberNavController())
}
