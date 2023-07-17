package com.example.mymusicapi


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SongsViewModel:ViewModel() {
    var errorMessage: String by mutableStateOf("")
    var songDetails:Songs by mutableStateOf(Songs())
    //    var songName:String? by mutableStateOf("")
    fun getDetails() : Songs {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val dezerData = apiService.getSDetails(q= "eminem")
                Log.d("api123","$dezerData")
                songDetails = dezerData
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
        return songDetails
    }

}
