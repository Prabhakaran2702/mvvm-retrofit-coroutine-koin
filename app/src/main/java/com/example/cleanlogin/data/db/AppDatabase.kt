package com.example.cleanlogin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanlogin.data.entities.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}