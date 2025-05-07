package com.example.hellokitty.ui.screens.mpesa


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.hellokitty.navigation.ROUT_HOME
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

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("M-Pesa") },
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
                    .paint(painter = painterResource(R.drawable.img_35), contentScale = ContentScale.FillBounds)

                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,



                ) {


                //Main Contents of the page


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Cyan.copy(alpha = 0.1f))

                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title
                    Text(
                        text = "Payment Purr-fection 🐾",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Cyan,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )


                    val mContext = LocalContext.current

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Pay with M-Pesa 🐾",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00BCD4)
                        )


                        Spacer(modifier = Modifier.height(10.dp))






                        //M-pesa button
                        Button(
                            onClick = {
                                val simToolKitLaunchIntent =
                                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                            },
                            colors = ButtonDefaults.buttonColors(Cyan),
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                        ) {



                            Image(
                                painter = painterResource(R.drawable.img_34),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.fillMaxWidth().width(450.dp)
                            )
                        }

                        //end of button


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


