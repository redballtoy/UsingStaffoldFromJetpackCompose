package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String, val title: String) {

    sealed class HomeScreen(
        route: String,
        title: String,
        val icon: ImageVector
    ): Screens(
        route,
        title
    ){
        object Favorite: HomeScreen("favorite", "Favorite", Icons.Filled.Favorite)
        object Notification: HomeScreen("notification", "Notification",Icons.Filled.Notifications)
        object Network: HomeScreen("network", "Network",Icons.Filled.Person)
    }

    sealed class


}
