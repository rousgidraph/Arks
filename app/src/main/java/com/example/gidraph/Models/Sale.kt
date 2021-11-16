package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sale(var date : Long, var merchant_id :Long, var total : Double ){
    @PrimaryKey(autoGenerate = true)
    var sale_id : Long = 0
}

