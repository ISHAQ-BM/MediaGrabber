package com.example.mediagrabber.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mediagrabber.ui.navigation.MediaGrabberNavGraph
import com.example.mediagrabber.ui.navigation.MediaGrabberNavigationActions
import com.example.mediagrabber.ui.theme.MediaGrabberTheme

@Composable
fun MediaGrabberApp(

){

    MediaGrabberTheme {
        val navController = rememberNavController()
        MediaGrabberNavGraph(
            navHostController = navController
        )
    }
}