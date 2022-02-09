package com.aexample.notesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userDataBase")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var name : String?=null,
    var address:String?=null,
    var phone : Int?=null,
    var email : String?=null){

}
