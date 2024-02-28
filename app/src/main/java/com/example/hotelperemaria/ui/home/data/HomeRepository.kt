package com.example.hotelperemaria.ui.home.data

import com.example.hotelperemaria.ui.home.data.network.HomeService
import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeService) {
    suspend fun getRooms(): List<RoomsResponse> {
        return api.getRooms();
    }
}