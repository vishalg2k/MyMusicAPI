package com.example.mymusicapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymusicapi.ui.theme.MyMusicAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMusicAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MainAPP()
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAPP(viewModel: SongsViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    var artist by remember {
        mutableStateOf("")
    }
    var bool by remember {
        mutableStateOf(false)
    }
    var passArtist:String? by remember {
        mutableStateOf("")
    }

    Column( modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(value = artist, onValueChange = { artist = it})
        Button(onClick = { bool = !bool }) {
            Text(text = "Click to get songs")
        }

            try {
               passArtist = viewModel.songDetails.data[0].preview
                

            }
            catch (ex: Exception) {
                Log.d("Exception", ex.toString())
            }
            Text(text = "$passArtist")

        



    }

}