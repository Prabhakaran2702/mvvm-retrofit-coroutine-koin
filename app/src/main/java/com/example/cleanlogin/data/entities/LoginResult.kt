package com.example.cleanlogin.data.entities

data class LoginResult(
    val success: User? = null,
    val error: Int? = null
)