package com.example.mediagrabber.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mediagrabber.ui.screens.DownloadScreen
import com.example.mediagrabber.ui.screens.HomeScreen

@Composable
fun MediaGrabberNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    startDestination: String =MediaGrabberDestinations.HOME_ROUTE,
){

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(MediaGrabberDestinations.HOME_ROUTE){
            HomeScreen()
        }
        composable(MediaGrabberDestinations.DOWNLOAD_ROUTE){
            DownloadScreen()
        }
    }
}