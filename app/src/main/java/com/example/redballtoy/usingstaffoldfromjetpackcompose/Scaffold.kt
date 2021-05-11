package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun AppScaffold() {
    val viewModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    var scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentScreen by viewModel.currentScreen.observeAsState()

    var topBar: @Composable () -> Unit = {
        TopBar(
            title = currentScreen!!.title,
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        )
    }

    if (currentScreen == Screens.DrawerScreens.Help) {
        topBar = {
            TopBar(
                title = Screens.DrawerScreens.Help.title,
                buttonIcon = Icons.Filled.ArrowBack,
                onButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
    }

    val bottomBar: @Composable () -> Unit = {
        if (currentScreen == Screens.DrawerScreens.Home || currentScreen is Screens.HomeScreen)
            BottomBar(
                navController = navController,
                screens = screensInHomeFromBottomNav
            )
    }


    Scaffold(
        topBar = {
            topBar()
        },
        bottomBar = {
            bottomBar()
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer { screen ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(scree)
            }
        }
    )
}

