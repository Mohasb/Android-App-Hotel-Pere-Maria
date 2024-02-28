package com.example.hotelperemaria.nav

// Routes
sealed class AppScreens(val route: String) {
    object home: AppScreens("home")
    object roomDetails: AppScreens("roomDetails")
    object user: AppScreens("user")
    object rating: AppScreens("rating")
}