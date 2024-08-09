package com.example.mediagrabber.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.mediagrabber.ui.navigation.MediaGrabberNavGraph
import com.example.mediagrabber.ui.navigation.MediaGrabberNavigationActions
import com.example.mediagrabber.ui.theme.MediaGrabberTheme

@Composable
fun MediaGrabberApp(

){

    MediaGrabberTheme {

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            MediaGrabberNavigationActions(navController)
        }

        MediaGrabberNavGraph(
            navHostController = navController,
            navigateToDownload = {socialMedia->navigationActions.navigateToDownload(socialMedia)}
        )
    }
}