package com.example.androidtestmakkode.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Condition(
    @SerializedName("code")
    var code: Int?,
    @SerializedName("icon")
    var icon: String?,
    @SerializedName("text")
    var text: String?
) : Parcelable