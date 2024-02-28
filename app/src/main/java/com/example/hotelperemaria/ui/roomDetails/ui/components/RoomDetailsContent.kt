package com.example.hotelperemaria.ui.roomDetails.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hotelperemaria.R

@Composable
fun RoomDetailsContent() {
    RoomDetailsImage()
    //ImageSlider(imageBase64List = )
}

@Composable
fun RoomDetailsImage() {
    val configuration = LocalConfiguration.current

    val contentScale = if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        ContentScale.FillHeight
    } else {
        ContentScale.FillWidth
    }

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clip(shape = RoundedCornerShape(16.dp)),
        contentScale = contentScale,
        painter = painterResource(id = R.drawable.ic_logoazul),
        contentDescription = "room images"
    )
}