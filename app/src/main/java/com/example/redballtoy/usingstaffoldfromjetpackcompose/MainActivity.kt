package com.example.redballtoy.usingstaffoldfromjetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.redballtoy.usingstaffoldfromjetpackcompose.theme.NavigationDrawerTheme

/*
* https://proandroiddev.com/bottom-navigation-and-navigation-drawer-using-scaffold-from-jetpack-compose-e2167440e7a9
* https://developer.android.com/jetpack/compose/setup
* */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                AppScaffold()
            }
        }

    }
}