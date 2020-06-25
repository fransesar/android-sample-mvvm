package com.example.mvvm.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @SerializedName("username")
    val username: String?,

    @SerializedName("password")
    val password: String?,

    @SerializedName("full_name")
    val fullname: String?,

    @SerializedName("nickname")
    val nickname: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("phone")
    val phone: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}