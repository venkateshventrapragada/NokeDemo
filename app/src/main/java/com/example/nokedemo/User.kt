package com.example.nokedemo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var Name: String,
    var Title: String,
    var Phone: String,
    var Street: String,
    var City: String,
    var State: String,
    var Zipcode: String,
    var Email: String,
    var Birthday: String,
    var Picture: String
): Parcelable

data class People(
   @SerializedName("People") val people: List<User>
)