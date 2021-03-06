package com.aexample.notesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aexample.notesapp.model.UserModel
import com.aexample.notesapp.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepo: UserRepo): ViewModel() {
    val getUserData : LiveData<List<UserModel>> = userRepo.getUserAllData

    fun insertUser(userModel: UserModel) = viewModelScope.launch {
        userRepo.addUserData(userModel)
    }
}