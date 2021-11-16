package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Sale
import com.example.gidraph.Models.sale_type

@Dao
interface sales_dao:BaseDao<Sale> {
    /*
    * sales database transactions
    * */


}