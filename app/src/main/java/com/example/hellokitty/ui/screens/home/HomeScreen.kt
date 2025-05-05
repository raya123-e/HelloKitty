package com.example.hellokitty.ui.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.R
import com.example.hellokitty.navigation.ROUT_ABOUT
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.ui.theme.Cyan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("EastAfrica,Kenya", fontFamily = FontFamily.SansSerif)

                        Spacer(modifier = Modifier.width(100.dp))

                        //Circular Image
                        Image(
                            painter = painterResource(R.drawable.img_20),
                            contentDescription = "",
                            modifier = Modifier.size(50.dp).clip(shape = CircleShape),
                            contentScale = ContentScale.Crop,
                        )
                        //End

                    }


                        },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Cyan,
                    titleContentColor = Color.Black,
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

                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,



                ) {


                //Main Contents of the page

                Image(
                    painter = painterResource(R.drawable.img_28),
                    contentDescription = "anime",
                    modifier = Modifier.fillMaxWidth().height(335.dp),
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.height(5.dp))


                //searchbar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it},
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                    placeholder = { Text(text = "Search......", fontWeight = FontWeight.Bold, fontSize = 20.sp) },


                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color.Black,
                        focusedBorderColor = Color.Cyan,
                        focusedTextColor = Color.Cyan,
                        cursorColor = Color.White,),




                        )

                //end of searchbar

                Spacer(modifier = Modifier.height(5.dp))



                //Main row




                Spacer(modifier = Modifier.height(5.dp))



                Row (
                    modifier = Modifier.fillMaxWidth()
                        .horizontalScroll(rememberScrollState())

                ){




                    //Card-1
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(290.dp)
                        .padding(start = 20.dp)
                        .clickable{navController.navigate(ROUT_ABOUT)}
                        .clip(shape = RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Cyan),


                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {
                            Spacer(modifier = Modifier.height(5.dp))


                            Text(text ="Persian", fontSize = 20.sp, color = Color.Black)

                            Spacer(modifier = Modifier.height(10.dp))


                            Image(
                                painter = painterResource(R.drawable.img_21),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.size(400.dp).fillMaxSize().clip(CircleShape)
                            )






                        }


                    }
                    //End of Card-1

                    Spacer(modifier = Modifier.width(10.dp))






                    //Card-2
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(290.dp)
                        .padding(start = 20.dp)
                        .clickable{navController.navigate(ROUT_ABOUT)}
                        .clip(shape = RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Cyan),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {

                            Spacer(modifier = Modifier.height(5.dp))




                            Text(text ="Ragdoll", fontSize = 20.sp, color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Image(
                                painter = painterResource(R.drawable.img_22),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.size(400.dp).fillMaxSize().clip(CircleShape).padding(start = 10.dp)
                            )





                        }


                    }
                    //End of Card-2

                    Spacer(modifier = Modifier.width(10.dp))



                    //Card-3
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(290.dp)
                        .padding(start = 20.dp)
                        .clickable{navController.navigate(ROUT_ABOUT)}
                        .clip(shape = RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Cyan),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {

                            Spacer(modifier = Modifier.height(5.dp))




                            Text(text ="Ragamuffin", fontSize = 20.sp, color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Image(
                                painter = painterResource(R.drawable.img_23),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.size(400.dp).fillMaxSize().clip(CircleShape).padding(start = 10.dp)
                            )





                        }


                    }
                    //End of Card-3

                    Spacer(modifier = Modifier.width(10.dp))



                    //Card-4
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(290.dp)
                        .padding(start = 20.dp)
                        .clickable{navController.navigate(ROUT_ABOUT)}
                        .clip(shape = RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Cyan),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {

                            Spacer(modifier = Modifier.height(5.dp))




                            Text(text ="Ragamuffin", fontSize = 20.sp, color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Image(
                                painter = painterResource(R.drawable.img_24),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.size(400.dp).fillMaxSize().clip(CircleShape).padding(start = 10.dp)
                            )





                        }


                    }
                    //End of Card-4


                    Spacer(modifier = Modifier.width(10.dp))



                    //Card-5
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(290.dp)
                        .padding(start = 20.dp)
                        .clickable{navController.navigate(ROUT_ABOUT)}
                        .clip(shape = RoundedCornerShape(10.dp)),
                        colors = CardDefaults.cardColors(Cyan),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center

                        ) {

                            Spacer(modifier = Modifier.height(5.dp))




                            Text(text ="Maine Coon", fontSize = 20.sp, color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Image(
                                painter = painterResource(R.drawable.img_25),
                                contentDescription = "Ecommerce",
                                modifier = Modifier.size(400.dp).fillMaxSize().clip(CircleShape).padding(start = 10.dp)
                            )





                        }


                    }
                    //End of Card-5









                }
                //end of main row













            }
        }
    )

    //End of scaffold




}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController= rememberNavController())
}