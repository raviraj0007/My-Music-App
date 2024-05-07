package com.example.mymusicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiInterface {

    @Headers("X-RapidAPI-Key: 4d4aee8752mshdb9df1d95775ab9p1206a0jsn1c79b3bdd6fa",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String) : Call<MyData>

}