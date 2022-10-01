package com.example.androidtestmakkode.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherResponse(
    @SerializedName("current")
    var current: Current?,
    @SerializedName("location")
    var location: Location?
) : Parcelable