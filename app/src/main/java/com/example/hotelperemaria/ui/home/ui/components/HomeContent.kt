package com.example.hotelperemaria.ui.home.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse

@Composable
fun HomeContent(
    topBarHeight: State<Dp>,
    scrollState: LazyListState,
    roomsList: State<List<RoomsResponse>?>,
    navigator: NavHostController
) {

    val items = roomsList.value.orEmpty().map { room ->
        BoxProperties(
            room = room, navController = navigator
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = topBarHeight.value + 15.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)), state = scrollState
    ) {

        items(items) { values ->
            GridItem(properties = values)
        }
    }
}

data class BoxProperties(
    val room: RoomsResponse, val navController: NavHostController
)

@Composable
fun GridItem(properties: BoxProperties) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        RoomCard(room = properties.room, navigator = properties.navController)
    }
}
