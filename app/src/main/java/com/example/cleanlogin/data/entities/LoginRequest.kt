package com.devtides.dogs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class LoginRequest(


    @SerializedName("userName")
    val userID: String?,

    @SerializedName("password")
    val password: String?


)

