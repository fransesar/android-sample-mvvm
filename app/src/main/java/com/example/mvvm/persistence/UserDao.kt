package com.example.mvvm.persistence

import androidx.room.*
import com.example.mvvm.data.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user_table WHERE email = :email")
    fun showUser(email: String): User
}