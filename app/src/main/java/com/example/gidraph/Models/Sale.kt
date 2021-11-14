package com.example.gidraph.Models

import androidx.room.PrimaryKey

data class Sale(var date : Long, var merchant_id :Long, var total : Double ){
    @PrimaryKey(autoGenerate = true)
    var sale_id : Long = 0
}

