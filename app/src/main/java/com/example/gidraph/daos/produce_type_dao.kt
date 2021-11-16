package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.produce_type

@Dao
interface produce_type_dao : BaseDao<produce_type> {

    @Transaction
    @Query("select * from produce_type")
    fun get_all_prod_types():List<produce_type>
}