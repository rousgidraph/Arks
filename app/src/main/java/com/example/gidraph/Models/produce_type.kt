package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class produce_type(var produce_name : String, var units_of_measure : String) {
    @PrimaryKey(autoGenerate = true)
    var type_id : Long = 0
}