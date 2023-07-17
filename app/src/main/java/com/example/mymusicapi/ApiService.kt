package com.example.mymusicapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun getSDetails(@Query("q") q: String,
                               @Header("X-RapidAPI-Key") apiKey:String? = "2efcfed7a2msh16426c9755121ecp1dd5e0jsn27071d37ca8f",
                               @Header("X-RapidAPI-Host") apiHost: String? = "deezerdevs-deezer.p.rapidapi.com"):Songs


    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
//                    .baseUrl("https://api.weatherapi.com/v1/")
                    .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}
/* val client = OkHttpClient()

val mediaType = MediaType.parse("application/json")
val body = RequestBody.create(mediaType, "{\n    \"search\": \"Rajdhani\"\n}")
val request = Request.Builder()
	.url("https://trains.p.rapidapi.com/")
	.post(body)
	.addHeader("content-type", "application/json")
	.addHeader("X-RapidAPI-Key", "2efcfed7a2msh16426c9755121ecp1dd5e0jsn27071d37ca8f")
	.addHeader("X-RapidAPI-Host", "trains.p.rapidapi.com")
	.build()

val response = client.newCall(request).execute()*/

//{
//    interface ApiService {
//        @GET("current.json?key=49df246b0a994969914165108231207")
//        suspend fun getWeather(@Query("q") city: String ,
//                               @Query("aqi") aqi: String) : WeatherClass
//        companion object {
//            private var apiService: ApiService? = null
//            fun getInstance() : ApiService {
//                if (apiService == null) {
//                    apiService = Retrofit.Builder()
//                        .baseUrl("https://api.weatherapi.com/v1/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build().create(ApiService::class.java)
//                    Log.d("API","New API Connection good")
//                }else{
//                    Log.d("API_Old","API Connection already existed")
//                }
//                return apiService!!
//            }
//        }
//    }
//}