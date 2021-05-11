package com.example.redballtoy.usingstaffoldfromjetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//used to keep track of the screen we are on
class MainViewModel : ViewModel() {
    private val _currentScreen = MutableLiveData<Screens>(Screens.DrawerScreens.Home)
    val currentScreen: LiveData<Screens> = _currentScreen

    fun setCurrentScreen(screen: Screens) {
        _currentScreen.value = screen
    }
}
