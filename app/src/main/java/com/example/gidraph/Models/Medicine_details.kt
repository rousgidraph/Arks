package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine_details(var name : String, var manufacturer : String, var treatmentFor : String , var prescrition : String , var comment: String ? = "" ){
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}
