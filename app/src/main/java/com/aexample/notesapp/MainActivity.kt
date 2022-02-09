package com.aexample.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aexample.notesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.tvAddUser.setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }
        binding.tvSeeUser.setOnClickListener {
            startActivity(Intent(this,ShowAllUsersActivity::class.java))
        }
    }
}