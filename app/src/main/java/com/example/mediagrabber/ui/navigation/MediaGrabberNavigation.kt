package com.example.mediagrabber.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object MediaGrabberDestinations {
    const val HOME_ROUTE = "home"
    const val DOWNLOAD_ROUTE = "download"
}

class MediaGrabberNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(MediaGrabberDestinations.HOME_ROUTE) {

            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToDownload: () -> Unit = {
        navController.navigate(MediaGrabberDestinations.DOWNLOAD_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}