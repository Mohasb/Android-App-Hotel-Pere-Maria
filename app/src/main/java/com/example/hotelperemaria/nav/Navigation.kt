package com.example.hotelperemaria.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hotelperemaria.ui.home.ui.HomeScreen
import com.example.hotelperemaria.ui.home.ui.HomeViewModel
import com.example.hotelperemaria.ui.ratings.ui.RatingScreen
import com.example.hotelperemaria.ui.roomDetails.ui.RoomDetails
import com.example.hotelperemaria.ui.roomDetails.ui.RoomViewModel
import com.example.hotelperemaria.ui.user.ui.UserScreen
import com.example.hotelperemaria.ui.user.ui.UserViewModel


@Composable
fun AppNavigation(homeViewModel: HomeViewModel, roomViewModel: RoomViewModel, userViewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.home.route) {
        // HomeScreen
        composable(route = AppScreens.home.route) {
            HomeScreen(viewModel = homeViewModel, navigator = navController)
        }
        //Room Details
        composable(
            AppScreens.roomDetails.route + "/{roomType}",
            arguments = listOf(navArgument("roomType") { type = NavType.StringType })
        ) { backStackEntry ->
            RoomDetails(
                roomViewModel,
                navController,
                backStackEntry.arguments?.getString("roomType") ?: "Not roomType"
            )
        }
        composable(route = AppScreens.user.route) {
            UserScreen(viewModel = userViewModel, navigator = navController)
        }
        composable(route = AppScreens.rating.route) {
            RatingScreen(navigator = navController)
        }
    }
}

