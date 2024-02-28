package com.example.hotelperemaria.components

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(imageBase64List: List<String>) {
    var currentPage by remember { mutableStateOf(0) }
    val state = rememberPagerState { 3 }

    // Use LaunchedEffect to automatically change the page every 5 seconds
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            currentPage = (currentPage + 1) % imageBase64List.size
            state.animateScrollToPage(currentPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        HorizontalPager(
            state = state, modifier = Modifier.fillMaxSize()
        ) { page ->
            val base64Image = imageBase64List.getOrNull(page)
            if (base64Image != null) {
                val byteArray = Base64.decode(base64Image, Base64.DEFAULT)
                val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .height(300.dp)
                        .clip(shape = RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        DotsIndicator(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 16.dp),
            pageCount = imageBase64List.size,
            currentPage = state.currentPage,
            onPageSelected = { newPage ->
                currentPage = newPage
            })
    }
}


@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier, pageCount: Int, currentPage: Int, onPageSelected: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { index ->
            Dot(isSelected = index == currentPage, onClick = {
                onPageSelected(index)
            })
        }
    }
}

@Composable
fun Dot(
    isSelected: Boolean, onClick: () -> Unit
) {
    val dotColor =
        if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    Box(modifier = Modifier
        .size(15.dp)
        .padding(4.dp)
        .clickable { onClick() }
        .background(color = dotColor, shape = MaterialTheme.shapes.small))
}