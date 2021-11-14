package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class sale_type(var sale_name: String, var unit_of_measure:String){
    @PrimaryKey(autoGenerate = true)
    var sale_type_id : Long = 0

}

