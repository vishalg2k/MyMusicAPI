package com.example.mymusicapi

import com.google.gson.annotations.SerializedName


data class Songs (

    @SerializedName("data"  ) var data  : ArrayList<Data> = arrayListOf(),
    @SerializedName("total" ) var total : Int?            = null,
    @SerializedName("next"  ) var next  : String?         = null

)
