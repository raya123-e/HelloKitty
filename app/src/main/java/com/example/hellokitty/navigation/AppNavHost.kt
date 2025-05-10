package com.example.hellokitty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hellokitty.ui.screens.dashboard.DashboardScreen
import com.example.hellokitty.data.UserDatabase
import com.example.hellokitty.repository.UserRepository
import com.example.hellokitty.ui.screens.about.AboutScreen
import com.example.hellokitty.ui.screens.auth.LoginScreen
import com.example.hellokitty.ui.screens.auth.RegisterScreen
import com.example.hellokitty.ui.screens.card.CardScreen
import com.example.hellokitty.ui.screens.cats.MaineCoonScreen
import com.example.hellokitty.ui.screens.cats.PersianScreen
import com.example.hellokitty.ui.screens.cats.RagamuffinScreen
import com.example.hellokitty.ui.screens.cats.RagdollScreen
import com.example.hellokitty.ui.screens.cats.WirehairScreen
import com.example.hellokitty.ui.screens.contact.ContactScreen
import com.example.hellokitty.ui.screens.home.HomeScreen
import com.example.hellokitty.ui.screens.mpesa.MpesaScreen
import com.example.hellokitty.ui.screens.payment.PaymentScreen
import com.example.hellokitty.ui.screens.splash.SplashScreen
import com.example.hellokitty.ui.screens.start.StartScreen
import com.example.hellokitty.viewmodel.AuthViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }


        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }


        composable(ROUT_START) {
            StartScreen(navController)
        }

        composable(ROUT_PERSIAN) {
            PersianScreen(navController)
        }


        composable(ROUT_RAGDOLL) {
            RagdollScreen(navController)
        }


        composable(ROUT_RAGAMUFFIN) {
            RagamuffinScreen(navController)
        }


        composable(ROUT_WIREHAIR) {
            WirehairScreen(navController)
        }


        composable(ROUT_MAINECOON) {
            MaineCoonScreen(navController)
        }

        composable(ROUT_CARD) {
            CardScreen(navController)
        }


        composable(ROUT_MPESA) {
            MpesaScreen(navController)
        }


        composable(ROUT_PAYMENT) {
            PaymentScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }















    }
}