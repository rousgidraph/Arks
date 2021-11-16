package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal(
    var animal_type : String ,
    var animal_name : String? = "" ,
    var date_of_birth : Long? = 0 ,
    var origin : String,
    var breed : String? = "",
    var comment : String? = ""){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
