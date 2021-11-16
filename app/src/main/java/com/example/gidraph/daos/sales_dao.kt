package com.example.gidraph.daos

import androidx.room.*
import com.example.gidraph.Models.Sale
import com.example.gidraph.Models.sale_type

@Dao
interface sales_dao {
    /*
    * sales database transactions
    * */

    @Insert
    fun insert(obj:Sale):Long

    @Update
    fun update(obj: Sale)

    @Delete
    fun delete(obj: Sale)


}