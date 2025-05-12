package com.example.hellokitty.ui.screens.mpesa


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
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




@Preview(showBackground = true)
@Composable
fun MpesaScreenPreview(){
    MpesaScreen(navController= rememberNavController())
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MpesaScreen( navController: NavController


) {




    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }
    val mContext = LocalContext.current

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("M-Pesa", color = Color.Black) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_PAYMENT) }) {
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
                        navController.navigate(ROUT_DASHBOARD)
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
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,


                ) {


                //Main Contents of the page

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFF4BBA7), // your background color
                                    Color(0xFFFCE4EC),
                                    Color(0xFFE1BEE7)
                                )
                            )
                        )
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Header
                    Text(
                        text = "Payment Purr-fection",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF641B80), // Deep brownish-purple
                        fontFamily = FontFamily.Serif
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Pay with",
                        fontSize = 20.sp,
                        color = Color(0xFF8D1BBB)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // M-Pesa Button (styled like image)
                    Button(
                        onClick = {

                            val simToolKitLaunchIntent =
                                mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                            simToolKitLaunchIntent?.let { mContext.startActivity(it)}

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFECB3)),
                        shape = RoundedCornerShape(32.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(64.dp)
                    ) {
                        Text(text = "M_PESA", color = Color.Green, fontSize = 30.sp, fontWeight = FontWeight.Bold

                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Adoption Button
                    Button(
                        onClick = { /* adoption nav */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8A65)),
                        shape = RoundedCornerShape(32.dp),
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(64.dp)
                    ) {
                        Text(
                            text = "Pawceed to Adoption",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }
    )

    //End of scaffold



}












