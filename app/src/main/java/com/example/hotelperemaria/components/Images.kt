package com.example.hotelperemaria.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hotelperemaria.R

@Composable
fun WhiteIcon(
    onclick: () -> Unit, modifier: Modifier, size: Dp
) {
    Image(painter = painterResource(id = R.drawable.ic_logoblanco),
        contentDescription = "icon hotel pere maria white",
        modifier = Modifier
            .size(size)
            .clickable { onclick() }
            .clip(RoundedCornerShape(50.dp)),
        contentScale = ContentScale.Fit)
}

@Composable
fun BlueIcon(
    onclick: () -> Unit, modifier: Modifier, size: Dp
) {
    Image(painter = painterResource(id = R.drawable.ic_logoazul),
        contentDescription = "icon hotel pere maria blue",
        modifier = Modifier
            .size(size)
            .clickable { onclick() }
            .clip(RoundedCornerShape(size / 4)),
        contentScale = ContentScale.Fit)
}

@Composable
fun NeutralIcon(
    onclick: () -> Unit, modifier: Modifier, size: Dp
) {
    Image(painter = painterResource(id = R.drawable.ic_logoneutro),
        contentDescription = "icon hotel pere maria blue",
        modifier = Modifier
            .size(size)
            .clickable { onclick() }
            .clip(RoundedCornerShape(50.dp)),
        contentScale = ContentScale.Fit)
}

@Composable
fun MainBackground() {
    val configuration = LocalConfiguration.current

    val contentScale = if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        ContentScale.FillHeight
    } else {
        ContentScale.FillWidth
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = contentScale,
        painter = painterResource(id = R.drawable.ic_main_background),
        contentDescription = "Background Image"
    )
}