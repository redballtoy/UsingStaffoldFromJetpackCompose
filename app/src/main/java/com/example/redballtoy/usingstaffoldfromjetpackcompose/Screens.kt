package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.redballtoy.usingstaffoldfromjetpackcompose.theme.NavigationDrawerTheme

sealed class Screens(val route: String, val title: String) {

    //screens for navigation from bottom nav
    sealed class HomeScreen(
        route: String,
        title: String,
        val icon: ImageVector
    ) : Screens(
        route,
        title
    ) {
        object Favorite : HomeScreen("favorite", "Favorite", Icons.Filled.Favorite)
        object Notification : HomeScreen("notification", "Notification", Icons.Filled.Notifications)
        object Network : HomeScreen("network", "Network", Icons.Filled.Person)
    }

    //screens for navigation from drawer
    sealed class DrawerScreens(
        route: String,
        title: String
    ) : Screens(route, title) {
        object Home : DrawerScreens("home", "Home")
        object Account : DrawerScreens("account", "Account")
        object Help : DrawerScreens("help", "Help")
    }
}

val screensInHomeFromBottomNav = listOf<Screens.HomeScreen>(
    Screens.HomeScreen.Favorite,
    Screens.HomeScreen.Notification,
    Screens.HomeScreen.Network
)

val screensFromDrawer = listOf<Screens.DrawerScreens>(
    Screens.DrawerScreens.Home,
    Screens.DrawerScreens.Account,
    Screens.DrawerScreens.Help
)

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    viewModel.setCurrentScreen(Screens.DrawerScreens.Home)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home", style = MaterialTheme.typography.h4)
    }
}

    @Composable
    fun Drawer(
        modifier: Modifier = Modifier,
        onDestinationClicked: (route: String) -> Unit
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 48.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_baseline_android_24),
                contentDescription = "App icon"
            )
            screensFromDrawer.forEach { screen ->
                Spacer(Modifier.height(24.dp))
                Text(
                    text = screen.title,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.clickable {
                        onDestinationClicked(screen.route)
                    }
                )

            }
        }
    }

@Preview
@Composable
fun DrawerPreview(){
    NavigationDrawerTheme {
        Drawer{}
    }
}