package com.example.mediagrabber.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DownloadScreen(
    modifier: Modifier = Modifier,
    socialMedia: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Download",
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    ) {
        Box(
            modifier = modifier

                .padding(top = it.calculateTopPadding())
                .padding(horizontal = 16.dp)
                .clip(shape = ShapeDefaults.Medium)
                .background(Color(0x5984C4F7))
                .padding(16.dp)
                .fillMaxWidth()


        ) {
            Column {
                var url by remember {
                    mutableStateOf("")
                }
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    modifier = modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = ShapeDefaults.Small


                )
                Spacer(modifier = modifier.height(16.dp))
                Row {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = ShapeDefaults.Medium,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF83C0F0))

                    ) {
                        Text(
                            text = "Paste link",
                            color = Color.Black
                        )

                    }
                    Spacer(modifier = modifier.width(8.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = ShapeDefaults.Medium,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF54C75A))

                    ) {
                        Text(text = "Download")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun p() {
    DownloadScreen(socialMedia = "ff")
}