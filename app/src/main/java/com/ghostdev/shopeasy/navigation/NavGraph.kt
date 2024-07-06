package com.ghostdev.shopeasy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ghostdev.shopeasy.ui.presentation.checkout.CheckoutComponent
import com.ghostdev.shopeasy.ui.presentation.home.HomeComponent

@Composable
fun NavGraph(controller: NavHostController) {
    NavHost(navController = controller, startDestination = NavDestinations.Home.toString()) {
        composable(NavDestinations.Home.toString()) {
        }
        composable(NavDestinations.Checkout.toString()) {
        }
    }
}