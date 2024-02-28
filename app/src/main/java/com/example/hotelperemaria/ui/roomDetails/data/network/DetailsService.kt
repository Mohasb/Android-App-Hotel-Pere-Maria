package com.example.hotelperemaria.ui.roomDetails.data.network

import com.example.hotelperemaria.ui.roomDetails.data.network.response.RoomResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailsService @Inject constructor(private val detailsCLient: DetailsClient) {
    suspend fun getRoom(roomType: String): RoomResponse {
        return withContext(Dispatchers.IO) {
            val room = detailsCLient.getRoom(roomType)
            room
        }
    }
}