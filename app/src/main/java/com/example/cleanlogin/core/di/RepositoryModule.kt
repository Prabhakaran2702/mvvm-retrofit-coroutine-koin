package com.example.cleanlogin.core.di

import com.example.cleanlogin.data.db.UserDao
import com.example.cleanlogin.data.remote.UserApi
import com.example.cleanlogin.data.repository.UserRepository

import org.koin.dsl.module

val repositoryModule = module {
    fun provideUserRepository(api: UserApi, dao: UserDao): UserRepository {
        return UserRepository(api, dao)
    }

    single { provideUserRepository(get(), get()) }
}