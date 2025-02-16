package com.yoyi.theyoyismovies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MovieNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        /*splashScreen(navController)
        authScreen(navController)
        homeScreen(navController)
        movieDetailScreen(navController)
        searchScreen(navController)
        playerScreen(navController)
        profileScreen(navController)*/
    }
}

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Auth : Screen("auth")
    object Home : Screen("home")
    object MovieDetail : Screen("movie/{movieId}") {
        fun createRoute(movieId: Long) = "movie/$movieId"
    }
    object Search : Screen("search")
    object Player : Screen("player/{movieId}") {
        fun createRoute(movieId: Long) = "player/$movieId"
    }
    object Profile : Screen("profile")
}