package com.example.mediagrabber.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mediagrabber.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier=Modifier,
    navigateToDownload:(String)->Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MediaGrabber",
                        fontWeight = FontWeight.SemiBold
                        )
                }
            )
        }
    ){
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp),
            modifier=modifier.padding(top = it.calculateTopPadding())
        ){

            itemsIndexed(socialMediaImages) { index, item  ->
                Card (
                    modifier=modifier.fillMaxWidth().clickable {
                        navigateToDownload(socialMedia[index])
                    }
                ){
                   Image(
                       painter = painterResource(id = item),
                       contentDescription =null,
                       contentScale = ContentScale.Crop,
                       modifier = modifier
                           .fillMaxWidth()
                           .height(200.dp)
                   )
                }
            }
        }
    }

}

val socialMediaImages = listOf(
    R.drawable.facebook,
    R.drawable.instagram,
    R.drawable.tiktok,
    R.drawable.youtube,
    R.drawable.soundcloud,
    R.drawable.pinterest,
    R.drawable.linkedin,

)

val socialMedia = listOf(
    "facebook",
    "instagram",
    "tiktok",
    "youtube",
    "soundcloud",
    "pinterest",
    "linkedin",
)


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navigateToDownload = {})
}
