package com.aexample.notesapp.roomComponents

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aexample.notesapp.model.UserModel

@Dao
interface UserDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
   suspend fun addUser(userModel: UserModel)

   @Query("SELECT * FROM userDataBase ORDER BY id ASC")
   fun getUserData()  :LiveData<List<UserModel>>
}