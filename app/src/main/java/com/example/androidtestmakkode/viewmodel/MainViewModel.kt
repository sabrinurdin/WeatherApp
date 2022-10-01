package com.example.androidtestmakkode.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtestmakkode.model.WeatherResponse
import com.example.androidtestmakkode.repository.MainRepository
import com.example.androidtestmakkode.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
) : ViewModel() {

    private val _weatherResponse = MutableLiveData<Resource<WeatherResponse>>()
    val weatherResponse: MutableLiveData<Resource<WeatherResponse>>
        get() = _weatherResponse


     fun getWeather(key:String,location: String) = viewModelScope.launch{
        getWeatherSafeCall(key,location)
    }

    private suspend fun getWeatherSafeCall(key: String, location: String) {
        _weatherResponse.value = Resource.Loading()
        try {
            val response = repository.remote.getWeather(key,location)
            _weatherResponse.value = handleWeatherResponse(response)
        } catch (e : Exception){
            e.printStackTrace().toString()
            _weatherResponse.value = Resource.Error("Weather not found")
        }

    }

    private fun handleWeatherResponse(response: Response<WeatherResponse>): Resource<WeatherResponse>? {
        return when {

            response.isSuccessful -> {
                val weather = response.body()
                Resource.Success(weather!!)
            } else -> {
                Resource.Error(response.message())
            }
        }
    }

}