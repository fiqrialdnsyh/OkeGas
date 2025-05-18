package com.example.okegass1.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.okegass1.ui.screens.HomeScreen
import com.example.okegass1.ui.theme.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.filled.AdsClick
import com.example.okegass1.ui.theme.BottomNavItem
import com.example.okegass1.ui.theme.BottomNavigationBar


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    val bottomNavItems = listOf(
        BottomNavItem("home", "Home", Icons.Default.Home),
        BottomNavItem("simulasi", "Simulasi", Icons.Default.AdsClick),
        BottomNavItem("profile", "Profile", Icons.Default.Person)
    )

    AnimatedNavHost(
        navController = navController,
        startDestination = "splash",
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
        }
    ) {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("home") {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, bottomNavItems)
                }
            ) { padding: PaddingValues -> // <-- tipe PaddingValues eksplisit
                HomeScreen(navController, modifier = Modifier.padding(padding))
            }
        }
        composable("simulasi") {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, bottomNavItems)
                }
            ) { padding: PaddingValues ->
                SimulasiScreen(
                    modifier = Modifier.padding(padding),
                    onSimulasiClick = { input ->
                        navController.currentBackStackEntry
                            ?.savedStateHandle
                            ?.set("simulasi_input", input)

                        navController.navigate("result")
                    }
                )
            }
        }
        composable("profile") {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(navController, bottomNavItems)
                }
            ) { padding: PaddingValues ->
                val email = navController.currentBackStackEntry?.savedStateHandle?.get<String>("user_email") ?: "user@example.com"
                ProfileScreen(navController, email = email, modifier = Modifier.padding(padding))
            }
        }
        composable("informasi_pribadi") { backStackEntry ->
            val userEmail = backStackEntry.savedStateHandle.get<String>("user_email") ?: ""
            InformasiPribadiScreen(navController, userEmail)
        }
        composable("edit_profile") { EditProfileScreen(navController) }
        composable("notifikasi") { NotifikasiScreen(navController) }
        composable("result") {
            val input = navController.previousBackStackEntry
                ?.savedStateHandle?.get<SimulasiInput>("simulasi_input")

            input?.let {
                ResultScreen(
                    input = it,
                    onBack = { navController.popBackStack() }
                )
            }
        }
        composable("informasi_wisata") {
            InformasiWisataScreen(navController)
        }
        composable("currency_exchange") {
            CurrencyExchangeScreen(navController)
        }
        composable("penginapan") {
            PenginapanScreen(navController)
        }
        composable(
            route = "result_penginapan/{provinsi}",
            arguments = listOf(navArgument("provinsi") { type = NavType.StringType })
        ) { backStackEntry ->
            val provinsi = backStackEntry.arguments?.getString("provinsi") ?: ""
            ResultPenginapanScreen(navController, provinsi)
        }
        composable(
            route = "detail_penginapan/{nama}/{kota}/{harga}/{imageRes}",
            arguments = listOf(
                navArgument("nama") { type = NavType.StringType },
                navArgument("kota") { type = NavType.StringType },
                navArgument("harga") { type = NavType.StringType },
                navArgument("imageRes") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val nama = backStackEntry.arguments?.getString("nama") ?: ""
            val kota = backStackEntry.arguments?.getString("kota") ?: ""
            val harga = backStackEntry.arguments?.getString("harga") ?: ""
            val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
            DetailPenginapanScreen(nama, kota, harga, imageRes, navController)
        }
        composable(
            route = "detail_wisata/{idWisata}",
            arguments = listOf(navArgument("idWisata") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("idWisata") ?: return@composable
            DetailWisataScreen(idWisata = id, onBack = { navController.popBackStack() })
        }
        composable(
            route = "result_currency_exchange/{amount}/{fromCode}/{fromName}/{toCode}/{toName}/{convertedAmount}/{rateFromTo}/{rateToFrom}",
            arguments = listOf(
                navArgument("amount") { type = NavType.StringType },
                navArgument("fromCode") { type = NavType.StringType },
                navArgument("fromName") { type = NavType.StringType },
                navArgument("toCode") { type = NavType.StringType },
                navArgument("toName") { type = NavType.StringType },
                navArgument("convertedAmount") { type = NavType.StringType },
                navArgument("rateFromTo") { type = NavType.StringType },
                navArgument("rateToFrom") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            val args = backStackEntry.arguments!!
            ResultCurrencyExchangeScreen(
                navController,
                amount = args.getString("amount") ?: "",
                fromCurrencyCode = args.getString("fromCode") ?: "",
                fromCurrencyName = args.getString("fromName") ?: "",
                toCurrencyCode = args.getString("toCode") ?: "",
                toCurrencyName = args.getString("toName") ?: "",
                convertedAmount = args.getString("convertedAmount") ?: "",
                rateFromTo = args.getString("rateFromTo") ?: "",
                rateToFrom = args.getString("rateToFrom") ?: ""
            )
        }
    }
}


