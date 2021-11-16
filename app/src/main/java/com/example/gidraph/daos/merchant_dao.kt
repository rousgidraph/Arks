package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Merchant
import com.example.gidraph.Models.Vet

@Dao
interface  merchant_dao : BaseDao<Merchant>{
    /*
    * all merchant database transactions
    * */

    @Transaction
    @Query("Select * from Merchant")
    fun load_merchants() : List<Merchant>

}