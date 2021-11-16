package com.example.gidraph.Models.views

import androidx.room.DatabaseView

@DatabaseView("select sale_type.sale_name'name' , sum(sale_item.item_count)'total' from sale_type, sale_item where sale_item.sale_type_id = sale_type.sale_type_id group by sale_type.sale_type_id")
data class sale_score (var name:String , var total:Long)
//which simply shows the most popular sale