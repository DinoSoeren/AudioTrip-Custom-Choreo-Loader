package com.audiotrippers.customchoreoloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.audiotrippers.customchoreoloader.ui.theme.AudioTripCustomChoreoLoaderTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AudioTripCustomChoreoLoaderTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
          ChoreoListItem(ChoreoPost("Song", "Artist"))
        }
      }
    }
  }
}

@Composable
fun ChoreoListItem(choreo: ChoreoPost) {
  Text(text = "${choreo.songTitle} by ${choreo.songArtist}")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  AudioTripCustomChoreoLoaderTheme {
    ChoreoListItem(ChoreoPost("Song", "Artist"))
  }
}