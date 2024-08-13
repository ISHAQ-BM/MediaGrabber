package com.example.mediagrabber.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.mediagrabber.R
import com.example.mediagrabber.ui.theme.MediaGrabberTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediaGrabberApp(
    modifier: Modifier = Modifier,
    mediaGrabberViewModel: MediaGrabberViewModel = hiltViewModel(),

    ) {

    MediaGrabberTheme {
        val uiState by mediaGrabberViewModel.uiState.collectAsStateWithLifecycle()
        val sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember { mutableStateOf(false) }
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "MediaGrabber"
                        )
                    }
                )
            }
        ) {
            Column(
                modifier = modifier
                    .padding(top = it.calculateTopPadding())
                    .padding(horizontal = 24.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var url by remember {
                        mutableStateOf("")
                    }
                    OutlinedTextField(
                        value = url,
                        onValueChange = { url = it },
                        modifier = modifier.weight(1f),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        ),
                        maxLines = 1,
                        shape = ShapeDefaults.Small


                    )
                    Spacer(modifier = modifier.width(4.dp))
                    IconButton(
                        onClick = {
                            mediaGrabberViewModel.getDownloadableUrl(url)
                            showBottomSheet = true
                        },
                        modifier = modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xFF21c197)
                        )
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.ic_download),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = modifier.size(28.dp)

                        )
                    }
                }


            }
            if (showBottomSheet)
                BottomSheet(
                    onDismiss = { showBottomSheet = false },
                    sheetState = sheetState,
                    qualities = uiState.links.keys.toList(),
                    imageUrl = uiState.imageUrl,
                    title = uiState.title,
                    download = { quality ->
                        mediaGrabberViewModel.download(
                            uiState.links[quality] ?: ""
                        )
                    },
                    isLoading = uiState.isLoading
                )

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(),
    qualities: List<String>,
    imageUrl: String,
    title: String,
    download: (String) -> Unit,
    isLoading: Boolean
) {


    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            if (isLoading)
                CircularProgressIndicator()
            else {
                Column {
                    var url by remember {
                        mutableStateOf(qualities[0])
                    }
                    HorizontalDivider()
                    Spacer(modifier = modifier.height(12.dp))

                    VideoInfo(imageUrl = imageUrl, title = title)
                    Spacer(modifier = modifier.height(12.dp))

                    HorizontalDivider()
                    Spacer(modifier = modifier.height(32.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_down),
                            contentDescription = null,
                            modifier = modifier
                                .clip(CircleShape)
                                .background(Color(0xFFced7f3))
                                .padding(2.dp)
                                .size(12.dp),
                            tint = Color(0xFF4275f5)
                        )
                        Spacer(modifier = modifier.width(16.dp))
                        Text(
                            text = "select quality",
                            color = Color(0xFF696c75)
                        )
                    }
                    Spacer(modifier = modifier.height(32.dp))


                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(qualities) { item ->
                            Quality(

                                modifier = modifier,
                                name = item,
                                isSelected = url == item,
                                onSelectionChanged = { name ->
                                    url = name
                                }
                            )
                        }
                    }
                    Button(
                        onClick = {
                            download(url)
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF21c197)
                        ),
                        modifier = modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = "Download")
                    }

                }
            }
        }


    }

}


@Composable
fun Quality(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onSelectionChanged: (String) -> Unit
) {
    Surface(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (!isSelected) Color.Gray else Color(0xFF4c7fff),
                shape = MaterialTheme.shapes.medium
            ),
        shape = MaterialTheme.shapes.medium,
        color = if (!isSelected) Color.White else Color(0xFFebf0fe)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
                .height(80.dp)
                .toggleable(value = isSelected,
                    onValueChange = {
                        onSelectionChanged(name)
                    })
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = extractQuality(name),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center

            )
        }

    }


}
//https://youtu.be/DAjMZ6fCPOo?feature=shared


@Composable
fun VideoInfo(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = modifier
                .size(72.dp)
                .clip(MaterialTheme.shapes.medium)
                .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.medium),

            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = modifier.width(12.dp))

        Column(
            modifier = modifier.height(72.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title)
            Text(
                text = "video is ready to save",
                color = Color(0xFF32c19e),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

fun extractQuality(quality: String): String {
    val regex = "\\(.*?\\)".toRegex()
    return quality.replace('_', ' ', true).replace(regex, "")

}
