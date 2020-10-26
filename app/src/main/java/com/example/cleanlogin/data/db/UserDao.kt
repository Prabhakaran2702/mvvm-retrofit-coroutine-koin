package com.example.cleanlogin.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanlogin.data.entities.User


@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun findAll(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: User)
}