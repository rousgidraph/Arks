package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Merchant(var name : String ,var email: String? = "" , var phone : String, var comment: String ? = ""){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
