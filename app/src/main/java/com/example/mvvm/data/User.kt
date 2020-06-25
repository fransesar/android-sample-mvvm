package com.example.mvvm.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val dogsId: String?,

    @SerializedName("name")
    val dogsName: String?,

    @SerializedName("life_span")
    val dogsLifeSpan: String?,

    @SerializedName("breed_group")
    val dogsBreedGroup: String?,

    @SerializedName("bred_for")
    val dogsBredFor: String?,

    @SerializedName("temperament")
    val dogsTemperament: String?,

    @SerializedName("url")
    val dogsImage: String?
)