package com.example.androidtestmakkode.repository

import com.example.androidtestmakkode.model.WeatherResponse
import com.example.androidtestmakkode.network.Endpoint
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val endpoint: Endpoint
) {
    suspend fun getWeather(key: String, location: String): Response<WeatherResponse> {
        return endpoint.getWeather(key, location)
    }
}