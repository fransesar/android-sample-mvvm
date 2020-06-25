package com.example.mvvm.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}