package com.example.cleanlogin.core.di


import com.example.cleanlogin.data.remote.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
   fun provideUserApi(retrofit: Retrofit): UserApi {
      return retrofit.create(UserApi::class.java)
   }

   single { provideUserApi(get()) }
}