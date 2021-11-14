package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Produce(var date: Long , var produce_type_id : Long , var quality : String, var quanity : Double , var comment: String ?=""  ){
    @PrimaryKey(autoGenerate = true)
    var produce_id: Long = 0
}
