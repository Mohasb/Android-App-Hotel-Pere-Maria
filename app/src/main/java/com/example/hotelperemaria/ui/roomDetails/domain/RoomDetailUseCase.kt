package com.example.hotelperemaria.ui.roomDetails.domain

import com.example.hotelperemaria.ui.roomDetails.data.DetailsRepository
import com.example.hotelperemaria.ui.roomDetails.data.network.response.RoomResponse
import javax.inject.Inject

class RoomDetailUseCase @Inject constructor(private val networkRepository: DetailsRepository) {
    suspend operator fun invoke(roomType: String): RoomResponse {
        return networkRepository.getRoom(roomType)
    }
}