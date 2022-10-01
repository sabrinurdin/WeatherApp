package com.example.androidtestmakkode.network

import com.example.androidtestmakkode.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("current.json?")
    suspend fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): Response<WeatherResponse>
}