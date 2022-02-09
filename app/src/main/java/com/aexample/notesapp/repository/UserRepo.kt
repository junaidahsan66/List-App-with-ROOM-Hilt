package com.aexample.notesapp.repository

import androidx.lifecycle.LiveData
import com.aexample.notesapp.model.UserModel
import com.aexample.notesapp.roomComponents.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepo @Inject constructor(private val userDao:UserDao) {

    val getUserAllData : LiveData<List<UserModel>> = userDao.getUserData()

    suspend fun addUserData(userModel: UserModel) = withContext(Dispatchers.IO){
        userDao.addUser(userModel)
    }
}