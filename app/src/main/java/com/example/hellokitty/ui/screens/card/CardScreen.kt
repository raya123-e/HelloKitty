package com.example.hellokitty.ui.screens.card




    import androidx.compose.foundation.background
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.rememberScrollState
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
    import androidx.compose.ui.text.font.FontFamily
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.navigation.compose.rememberNavController
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.NavController
    import com.example.hellokitty.navigation.ROUT_HOME
    import com.example.hellokitty.ui.theme.Cyan


@OptIn(ExperimentalMaterial3Api::class)
@Composable
            fun CardScreen(
                navController: NavController
            ) {


    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Contact") },
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

        //BottomBar
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
                        // navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Black) },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )

            }
        },

        //FloatingActionButton
        floatingActionButton = {

        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues )
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,



                ) {


                //Main Contents of the page

                var name by remember { mutableStateOf("") }
                var cardNumber by remember { mutableStateOf("") }
                var expiry by remember { mutableStateOf("") }
                var cvv by remember { mutableStateOf("") }
                var saveCard by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Cyan.copy(alpha = 0.1f))
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title
                    Text(
                        text = "Payment Purr-fection 💳🐾",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Cyan,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    // Name on Card
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = { Text("Name on Card") },
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Cyan,
                            cursorColor = Cyan
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )

                    // Card Number
                    OutlinedTextField(
                        value = cardNumber,
                        onValueChange = { cardNumber = it },
                        label = { Text("Card Number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Cyan,
                            cursorColor = Cyan
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )

                    // Expiry and CVV Row
                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = expiry,
                            onValueChange = { expiry = it },
                            label = { Text("Expiry") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Cyan,
                                cursorColor = Cyan
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal =  10.dp, vertical = 10.dp)
                        )

                        OutlinedTextField(
                            value = cvv,
                            onValueChange = { cvv = it },
                            label = { Text("CVV") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Cyan,
                                cursorColor = Cyan
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        )
                    }

                    // Save Card Toggle
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Switch(
                            checked = saveCard,
                            onCheckedChange = { saveCard = it },
                            colors = SwitchDefaults.colors(checkedThumbColor = Cyan)
                        )
                        Text(
                            text = "Save card for future meow-purchases 🐾",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    // Adopt Button
                    Button(
                        onClick = { /* navigate or show confirmation */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Cyan),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                    ) {
                        Text(
                            text = "Pawceed to Adoption 🐾",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                }


                }



        }
    )

    //End of scaffold

}







@Preview(showBackground = true)
@Composable
fun CardScreenPreview(){
    CardScreen(navController= rememberNavController())
}