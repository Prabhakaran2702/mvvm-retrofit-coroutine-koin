package com.example.cleanlogin

import android.app.Application
import com.example.cleanlogin.core.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {



    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(databaseModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(networkModule)
            modules(apiModule)
        }
    }

}