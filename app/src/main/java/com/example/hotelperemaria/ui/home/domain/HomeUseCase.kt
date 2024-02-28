package com.example.hotelperemaria.ui.home.domain

import com.example.hotelperemaria.ui.home.data.HomeRepository
import com.example.hotelperemaria.ui.home.data.network.response.RoomsResponse
import javax.inject.Inject

class HomeUseCase @Inject constructor(private val networkRepository: HomeRepository) {
    suspend operator fun invoke(): List<RoomsResponse> {
        return networkRepository.getRooms()
    }
}