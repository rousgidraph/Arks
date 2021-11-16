package com.example.gidraph.Models.views

import androidx.room.DatabaseView

@DatabaseView("select Merchant.name, sum(Sale.total)'total'  from Merchant,Sale where Sale.merchant_id =  Merchant.id group by Merchant.id")
data class merchant_score(var name:String,var total:Long)
/**
 *
 * */
