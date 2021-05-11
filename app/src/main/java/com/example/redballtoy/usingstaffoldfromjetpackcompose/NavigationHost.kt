package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.redballtoy.usingstaffoldfromjetpackcompose.Screens.DrawerScreens.Home
import com.example.redballtoy.usingstaffoldfromjetpackcompose.Screens.HomeScreen
import com.example.redballtoy.usingstaffoldfromjetpackcompose.Screens.HomeScreen.*

@Composable
fun NavigationHost(
    navController: NavController,
    viewModel: MainViewModel
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Home.route
    ){
        composable(Home.route){ Home(viewModel = viewModel) }
        composable(Favorite.route){ HomeScreen.Favorite(viewModel = viewModel) }
        composable(Home.route){ Home(viewModel = viewModel) }
        composable(Home.route){ Home(viewModel = viewModel) }
        composable(Home.route){ Home(viewModel = viewModel) }
        composable(Home.route){ Home(viewModel = viewModel) }


    }
}