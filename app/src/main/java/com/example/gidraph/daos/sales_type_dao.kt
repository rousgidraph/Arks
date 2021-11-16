package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.sale_type
import com.example.gidraph.Models.views.sale_score

@Dao
interface sales_type_dao : BaseDao<sale_type> {

    @Transaction
    @Query("select * from sale_type")
    fun get_sale_types():List<sale_type>

    @Transaction
    @Query("select * from sale_score")
    fun load_type_score(): List<sale_score>
}