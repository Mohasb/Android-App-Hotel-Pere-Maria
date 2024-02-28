package com.example.hotelperemaria.ui.home.data.network.response

import com.google.gson.annotations.SerializedName

data class RoomsResponse(
    @SerializedName("room_number") val roomNumber: Int,
    @SerializedName("type") val type: String,
    @SerializedName("description") val description: String,
    @SerializedName("images") val imagesList: List<Image>,
    @SerializedName("price_per_night") val pricePerNight: Double,
    @SerializedName("rate") val rate: Int,
    @SerializedName("max_occupancy") val maxOccupancy: Int,
    @SerializedName("isAvailable") val isAvailable: Boolean,
)

data class Image(
    @SerializedName("image1") val image1: String,
    @SerializedName("image2") val image2: String,
    @SerializedName("image3") val image3: String,

    )