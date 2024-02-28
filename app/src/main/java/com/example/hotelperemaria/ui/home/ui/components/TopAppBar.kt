package com.example.hotelperemaria.ui.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.components.BlueIcon

@Composable
fun TopBar(navigator: NavHostController, height: Dp, iconsColor: Color, hasIcon: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .background(Color.Transparent)
    ) {
        // Menu Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            //TODO: Show Menú
            IconButton(onClick = { navigator.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    tint = iconsColor,
                    contentDescription = "menu",
                    modifier = Modifier.size(100.dp)
                )
            }
        }

        if (hasIcon) {
            // Blue Icon in the Middle
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BlueIcon(onclick = { /*TODO*/ }, modifier = Modifier, size = height)
            }
        }


        // Person Icon on Top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp, top = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Icon(imageVector = Icons.Filled.Person,
                tint = iconsColor,
                contentDescription = "account",
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        navigator.navigate("UserScreen")
                    })
        }
    }
}