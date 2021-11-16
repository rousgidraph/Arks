package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class sale_type(var sale_name: String, var description:String){
    @PrimaryKey(autoGenerate = true)
    var sale_type_id : Long = 0

}

