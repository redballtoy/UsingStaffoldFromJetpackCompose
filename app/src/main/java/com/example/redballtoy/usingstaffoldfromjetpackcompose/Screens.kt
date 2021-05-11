package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String = "", val title: String = "") {

    //screens for navigation from drawer
    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Home : DrawerScreens("home", "Home")
        object Account : DrawerScreens("account", "Account")
        object Help : DrawerScreens("help", "Help")
    }

    //screens for navigation from bottom nav
    sealed class HomeScreen(
        route: String,
        title: String,
        val icon: ImageVector
    ) : Screens() {
        object Favorite : HomeScreen("favorite", "Favorite", Icons.Filled.Favorite)
        object Notification : HomeScreen("notification", "Notification", Icons.Filled.Notifications)
        object Network : HomeScreen("network", "Network", Icons.Filled.Person)
    }
}
