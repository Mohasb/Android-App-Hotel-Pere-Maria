package com.example.hotelperemaria.ui.roomDetails.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.components.Loading
import com.example.hotelperemaria.ui.home.ui.components.BottomBar
import com.example.hotelperemaria.ui.home.ui.components.TopBar
import com.example.hotelperemaria.ui.roomDetails.ui.components.OffsetBoxes


val heightTopAppBar = 100.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomDetails(viewModel: RoomViewModel, navigator: NavHostController, roomType: String) {

    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    viewModel.setRoomType(roomType)
    LaunchedEffect(roomType) {
        viewModel.loadRoomDetails()
    }

    val room = viewModel.room.observeAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Scaffold(containerColor = Color.Transparent, topBar = {
            TopBar(
                navigator = navigator,
                height = heightTopAppBar,
                iconsColor = MaterialTheme.colorScheme.secondary,
                hasIcon = false
            )
        }, bottomBar = { BottomBar() }, content = {
            if (isLoading) {
                Loading()
            } else {
                OffsetBoxes(navigator = navigator)
            }
        })

    }
}