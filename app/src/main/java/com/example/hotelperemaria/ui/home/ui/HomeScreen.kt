package com.example.hotelperemaria.ui.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.components.DialogHP
import com.example.hotelperemaria.components.Loading
import com.example.hotelperemaria.components.MainBackground
import com.example.hotelperemaria.ui.home.ui.components.BottomBar
import com.example.hotelperemaria.ui.home.ui.components.HomeContent
import com.example.hotelperemaria.ui.home.ui.components.TopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navigator: NavHostController) {

    val scrollState = rememberLazyListState()
    val topBarHeight = viewModel.calculateTopBarHeight(scrollState.firstVisibleItemIndex)
    // comentario mas largo
    val roomsList = viewModel.rooms.observeAsState()
    // State to show loader while getting data
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val error: Boolean by viewModel.error.observeAsState(initial = false)
    val errorMessage by viewModel.errorMessage.observeAsState()

    MainBackground()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Scaffold(containerColor = Color.Transparent, topBar = {
            TopBar(
                navigator = navigator,
                height = topBarHeight.value,
                iconsColor = MaterialTheme.colorScheme.primary,
                hasIcon = true
            )
        }, bottomBar = { BottomBar() }, content = {
            if (isLoading) {
                Loading()
            } else {
                if (!error) {
                    HomeContent(
                        roomsList = roomsList,
                        navigator = navigator,
                        topBarHeight = topBarHeight,
                        scrollState = scrollState
                    )
                } else {
                    errorMessage?.let { it1 ->
                        DialogHP(
                            onConfirmation = { },
                            dialogTitle = "ERROR AL OBTENER LAS HABITACIÓNES",
                            dialogText = it1,
                            icon = Icons.Filled.Warning
                        )
                    }

                }
            }
        })
    }

}