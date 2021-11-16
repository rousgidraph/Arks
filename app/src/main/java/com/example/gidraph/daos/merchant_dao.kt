package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Merchant
import com.example.gidraph.Models.Vet
import com.example.gidraph.Models.views.merchant_score

@Dao
interface  merchant_dao : BaseDao<Merchant>{
    /*
    * all merchant database transactions
    * */

    @Transaction
    @Query("Select * from Merchant")
    fun load_merchants() : List<Merchant>

    @Transaction
    @Query("select * from merchant_score")
    fun load_merchant_score(): List<merchant_score>

}