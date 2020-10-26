package com.example.cleanlogin.core.di

import android.app.Application
import androidx.room.Room
import com.example.cleanlogin.data.db.AppDatabase
import com.example.cleanlogin.data.db.UserDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

    val databaseModule = module {

        fun provideDatabase(application: Application): AppDatabase {
            return Room.databaseBuilder(application, AppDatabase::class.java, "eds.database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }


        fun provideDao(database: AppDatabase): UserDao {
            return database.userDao
        }

        single { provideDatabase(androidApplication()) }
        single { provideDao(get()) }
    }

