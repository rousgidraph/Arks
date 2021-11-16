package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class sale_item(var sale_id : Long , var sale_type_id : Long , var item_count: Double, var sale_name : String? =""){
    @PrimaryKey(autoGenerate = true)
    var sales_item_id : Long = 0
}
