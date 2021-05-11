package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationHost(
    navController: NavController,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.DrawerScreens.Home.route
    ) {
        composable(Screens.DrawerScreens.Home.route) { Home(viewModel = viewModel) }
        composable(Screens.DrawerScreens.Account.route) { Account(viewModel = viewModel) }
        composable(Screens.DrawerScreens.Help.route) { Help(viewModel = viewModel) }
        composable(Screens.HomeScreen.Favorite.route) { Favorite(viewModel = viewModel) }
        composable(Screens.HomeScreen.Notification.route) { Notification(viewModel = viewModel) }
        composable(Screens.HomeScreen.Network.route) { Network(viewModel = viewModel) }
    }
}