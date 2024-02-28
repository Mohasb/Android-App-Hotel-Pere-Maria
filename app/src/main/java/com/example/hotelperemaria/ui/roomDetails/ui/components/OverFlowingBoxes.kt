package com.example.hotelperemaria.ui.roomDetails.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.components.MainBackground
import com.example.hotelperemaria.components.WhiteIcon
import com.example.hotelperemaria.nav.AppScreens
import com.example.hotelperemaria.ui.roomDetails.ui.heightTopAppBar

@Composable
fun OffsetBoxes(navigator: NavHostController) {
    Surface {
        Boxes(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = heightTopAppBar, start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .clip(shape = RoundedCornerShape(50.dp)).background(Color.Red)
            ) {
                RoomDetailsContent()
            }

            WhiteIcon(
                onclick = { navigator.navigate(AppScreens.home.route) },
                modifier = Modifier.fillMaxSize(),
                size = 150.dp
            )

        }
    }

}

@Composable
fun Boxes(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val largeBox = measurables[0]
        val smallBox = measurables[1]
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val largePlaceable = largeBox.measure(looseConstraints)
        val smallPlaceable = smallBox.measure(looseConstraints)
        layout(
            width = constraints.maxWidth, height = constraints.maxHeight
        ) {
            largePlaceable.placeRelative(0, 0)
            smallPlaceable.placeRelative(
                x = (constraints.maxWidth - smallPlaceable.width) / 2,
                y = heightTopAppBar.toPx().toInt() - smallPlaceable.height / 2
            )
        }
    }
}