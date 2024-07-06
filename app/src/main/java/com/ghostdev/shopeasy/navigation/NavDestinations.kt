package com.ghostdev.shopeasy.navigation

sealed class NavDestinations(val route: String) {
    data object Home : NavDestinations("home")
    data object Checkout : NavDestinations("checkout")
}