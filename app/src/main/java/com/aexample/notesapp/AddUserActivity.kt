package com.aexample.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.aexample.notesapp.R
import com.aexample.notesapp.databinding.ActivityAddUserBinding
import com.aexample.notesapp.databinding.ActivityMainBinding
import com.aexample.notesapp.model.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddUserBinding
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_user)
        initViews()

    }

    private fun initViews() {
        binding.btSubmit.setOnClickListener {
            val userModel = UserModel()
            userModel.address = binding.titAddress.text.toString()
            userModel.phone = binding.titPhone.text.toString().toInt()
            userModel.name = binding.titName.text.toString()
            userModel.email = binding.titEmail.text.toString()
            userViewModel.insertUser(userModel)
        }
    }
}