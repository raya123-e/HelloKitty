package com.example.hellokitty.ui.screens.start

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import com.example.hellokitty.navigation.ROUT_ABOUT
import com.example.hellokitty.navigation.ROUT_HOME
import com.example.hellokitty.ui.theme.Cyan


@Composable
fun StartScreen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize(),

    ){

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .size(500.dp)
                .clip(shape = CutCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            .background(color = Cyan),
            colors = CardDefaults.cardColors(Cyan),




            ){

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Cyan)

            ) {
                Image(
                    painter = painterResource(R.drawable.img_19),
                    contentDescription = "Ecommerce",
                    modifier = Modifier.size(650.dp),

                    )
            }






        }

        Spacer(modifier = Modifier.height(24.dp))


       Column (

           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ){


           Text(
               text = "Make a new Friend",
               fontSize = 50.sp,
               fontFamily = FontFamily.Cursive,
               color =Cyan,
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.Bold,
           )

           Text(
               text = "Adopt your next feline soulmate, then track every whisker twitch—from health and habits to adorable chaos. This is the all-in-one app for cat lovers who care, obsess, and always have room for one more.",
               fontSize = 25.sp,
               fontFamily = FontFamily.Cursive,
               color = Color.Black,
               textAlign = TextAlign.Center,

               )
       }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(ROUT_HOME)
            },
            colors = ButtonDefaults.buttonColors(Cyan),
            shape = RoundedCornerShape(100.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
        ) {

            Row {

                Text(text = "Let's Go", color = Color.White, fontSize = 20.sp)

                Spacer(modifier = Modifier.width(20.dp))

                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")







            }

        }











    }


    }



@Preview(showBackground = true)
@Composable
fun StartScreenPreview(){
    StartScreen(rememberNavController())

}
