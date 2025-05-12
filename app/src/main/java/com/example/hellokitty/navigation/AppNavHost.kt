package com.example.hellokitty.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hellokitty.ui.screens.products.AddProductScreen
import com.example.hellokitty.ui.screens.products.EditProductScreen
import com.example.hellokitty.ui.screens.products.ProductListScreen
import com.example.hellokitty.ui.screens.dashboard.DashboardScreen
import com.example.hellokitty.data.UserDatabase
import com.example.hellokitty.repository.UserRepository
import com.example.hellokitty.ui.screen.vetscreen.VetScreen
import com.example.hellokitty.ui.screens.about.AboutScreen
import com.example.hellokitty.ui.screens.auth.LoginScreen
import com.example.hellokitty.ui.screens.auth.RegisterScreen
import com.example.hellokitty.ui.screens.card.CardScreen
import com.example.hellokitty.ui.screens.catcare.CatCareScreen
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
import com.example.hellokitty.viewmodel.ProductViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    productViewModel: ProductViewModel = viewModel(),

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


        // PRODUCTS
        composable(ROUT_ADD_PRODUCT) {
            AddProductScreen(navController, productViewModel)
        }

        composable(ROUT_PRODUCT_LIST) {
            ProductListScreen(navController, productViewModel)
        }

        composable(
            route = ROUT_EDIT_PRODUCT,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            if (productId != null) {
                EditProductScreen(productId, navController, productViewModel)
            }
        }


        composable(ROUT_CATCARE) {
            CatCareScreen(navController)
        }


        composable(ROUT_VET) {
            VetScreen(navController)
        }


















    }
}