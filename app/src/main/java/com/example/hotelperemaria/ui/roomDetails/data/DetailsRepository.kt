package com.example.hotelperemaria.ui.roomDetails.data

import com.example.hotelperemaria.ui.roomDetails.data.network.DetailsService
import com.example.hotelperemaria.ui.roomDetails.data.network.response.RoomResponse
import javax.inject.Inject

class DetailsRepository @Inject constructor(private val api: DetailsService) {
    suspend fun getRoom(roomType: String): RoomResponse {
        return api.getRoom(roomType);
    }
}