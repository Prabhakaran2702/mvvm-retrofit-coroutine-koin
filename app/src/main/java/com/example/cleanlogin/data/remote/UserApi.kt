package com.example.cleanlogin.data.remote

import com.devtides.dogs.model.LoginRequest
import com.example.cleanlogin.data.entities.LoginResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("mobileapi/webapi/login/validateUser")
    fun validateUser(@Body loginRequest: LoginRequest?): Deferred<LoginResponse>

}