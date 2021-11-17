package com.example.gidraph.Models.views

import android.os.Parcelable
import androidx.room.DatabaseView
import kotlinx.parcelize.Parcelize

@Parcelize
@DatabaseView("select Merchant.name, sum(Sale.total)'total'  from Merchant,Sale where Sale.merchant_id =  Merchant.id group by Merchant.id")
data class merchant_score(var name:String,var total:Long) : Parcelable
/**
 *
 * */
