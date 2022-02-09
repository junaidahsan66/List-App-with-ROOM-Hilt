package com.aexample.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.aexample.notesapp.R
import com.aexample.notesapp.adapters.UserAdapters
import com.aexample.notesapp.databinding.ActivityAddUserBinding
import com.aexample.notesapp.databinding.ActivityShowAllUsersBinding
import com.aexample.notesapp.model.UserModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowAllUsersActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowAllUsersBinding
    private lateinit var userAdapter: UserAdapters
    val userList = ArrayList<UserModel>()
    val userViewModel:UserViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_all_users)
        setUpAdapter()
        userViewModel.getUserData.observe(this, Observer {
            if (!it.isNullOrEmpty()){
                userList.addAll(it)
                userAdapter.notifyDataSetChanged()
            }
        })

    }

    private fun setUpAdapter() {
        // layout manager is declared in XML
        userAdapter = UserAdapters(this,userList,object : UserAdapters.Listener{
            override fun onClickListener(pos: Int) {
            }
        })
        binding.recy.adapter = userAdapter
    }
}