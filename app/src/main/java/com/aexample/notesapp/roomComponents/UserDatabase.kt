package com.aexample.notesapp.roomComponents

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aexample.notesapp.model.UserModel

@Database(entities = [UserModel::class],version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}