package com.example.cleanlogin.data.repository

import com.devtides.dogs.model.LoginRequest
import com.example.cleanlogin.data.db.UserDao
import com.example.cleanlogin.data.entities.LoginResponse
import com.example.cleanlogin.data.remote.UserApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userApi: UserApi, private val userDao:UserDao) {

    suspend fun validate(loginRequest: LoginRequest) : LoginResponse =
        withContext(Dispatchers.IO) {
          userApi.validateUser(loginRequest).await()
            //userDao.add(users)
        }

}