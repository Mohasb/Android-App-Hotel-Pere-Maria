package com.example.hotelperemaria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.hotelperemaria.nav.AppNavigation
import com.example.hotelperemaria.ui.home.ui.HomeViewModel
import com.example.hotelperemaria.ui.roomDetails.ui.RoomViewModel
import com.example.hotelperemaria.ui.theme.HotelPereMariaTheme
import com.example.hotelperemaria.ui.user.ui.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Aquí por que la etiqueta @AndroidEntryPoint solo funciona en MainActivty.kt y es la que importa viewModels()
    // Esto lo tenemos que ver con Jaume!!!
    private val homeViewModel: HomeViewModel by viewModels()
    private val roomViewModel: RoomViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelPereMariaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //Habrá que pasar todos los viewmodels al componente AppNavigation
                    AppNavigation(homeViewModel = homeViewModel, roomViewModel = roomViewModel, userViewModel = userViewModel)
                }
            }
        }
    }
}