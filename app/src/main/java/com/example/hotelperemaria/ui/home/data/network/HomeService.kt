package com.example.hotelperemaria.ui.home.data.network

import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeService @Inject constructor(private val homeClient: HomeClient) {
    suspend fun getRooms(): List<RoomsResponse> {
        return withContext(Dispatchers.IO) {
            val rooms = homeClient.getRooms()
            rooms
        }
    }
}