package com.example.hellokitty.ui.screens.cats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.ui.theme.Cyan


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RagdollScreen(navController: NavController){

    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Ragdoll", color = Color.Black) },
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
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,



                ) {


                //Main Contents of the page


                Box {

                    Image(
                        painter = painterResource(R.drawable.ragdoll),
                        contentDescription = "anime",
                        modifier = Modifier.fillMaxWidth().height(280.dp).fillMaxHeight(),
                        contentScale = ContentScale.FillWidth
                    )



                    //card
                    Card (modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.BottomCenter)
                        .offset(y = 250.dp)
                        .clip(shape = RoundedCornerShape(40.dp)),
                        colors = CardDefaults.cardColors(Color.White)


                    ){
                        Column (
                            modifier = Modifier.fillMaxSize().padding(start = 20.dp,end = 20.dp),





                            ) {
                            //row
                            Row {

                                Spacer(modifier = Modifier.height(20.dp))


                                Text(
                                    text = "Ragdoll Cat",
                                    fontSize = 30.sp,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black




                                )

                                Spacer(modifier = Modifier.width(50.dp))


                                Text(text = "80$", color = Color.Magenta, fontSize = 30.sp)





                            }
                            //end row

                            Spacer(modifier = Modifier.height(10.dp))




                            //row 2
                            Row {

                                //Card-1
                                Card(modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .padding(start = 10.dp),
                                    colors = CardDefaults.cardColors(Cyan)

                                )

                                {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,

                                        ) {


                                        Text(text ="Age", fontSize = 20.sp, color = Color.Red)

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(text ="0.5yrs", fontSize = 20.sp, color = Color.Black)




                                    }


                                }
                                //End of Card-1

                                Spacer(modifier = Modifier.width(20.dp))

                                //Card-2
                                Card(modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .padding(start = 10.dp),
                                    colors = CardDefaults.cardColors(Cyan)

                                )

                                {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,

                                        ) {


                                        Text(text ="Sex", fontSize = 20.sp, color = Color.Red)

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(text ="Male", fontSize = 20.sp, color = Color.Black)




                                    }


                                }
                                //End of Card-2

                                Spacer(modifier = Modifier.width(20.dp))


                                //Card-3
                                Card(modifier = Modifier
                                    .width(100.dp)
                                    .height(100.dp)
                                    .padding(start = 10.dp),
                                    colors = CardDefaults.cardColors(Cyan)

                                )

                                {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,

                                        ) {


                                        Text(text ="Color", fontSize = 20.sp, color = Color.Red)

                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(text ="Brown", fontSize = 20.sp, color = Color.Black)




                                    }


                                }
                                //End of Card-3

                                Spacer(modifier = Modifier.width(20.dp))












                            }
                            //end of row2


                            Spacer(modifier = Modifier.height(20.dp))


                            Text(text = "The Ragdoll is a breed of cat with a distinct colorpoint coat and blue eyes. Its morphology is large and weighty, and it has a semi-long and silky soft coat. They are best known for their docile, placid temperament and affectionate nature. Ragdolls are often known as \"dog-like cats\" or \"puppy-like cats\", due to their tendency to follow people around, their receptiveness to handling, and their relative lack of aggression towards other pets. "

                            )


                            Spacer(modifier = Modifier.height(20.dp))



                            Button(
                                onClick = {

                                },
                                colors = ButtonDefaults.buttonColors(Color.Unspecified),
                                shape = RoundedCornerShape(500.dp),
                                modifier = Modifier.fillMaxWidth(),
                            ) {

                                Image(
                                    painter = painterResource(R.drawable.img_29),
                                    contentDescription = "Ecommerce",
                                    modifier = Modifier.size(100.dp)
                                )

                                Spacer(modifier = Modifier.width(20.dp))

                                Text(
                                    text = "Adopt Now",
                                    color = Color.Black,
                                    fontSize = 30.sp,

                                    )










                            }






                        }





                    }
                    //end card

                }









            }
        }
    )

    //End of scaffold






}

@Preview(showBackground = true)
@Composable
fun RagdollScreenPreview(){
    RagdollScreen(navController= rememberNavController())
}