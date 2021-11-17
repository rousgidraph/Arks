package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Produce

@Dao
interface  produce_dao  : BaseDao<Produce>{
    /*
    * produce databsse transactions
    * */

    @Transaction
    @Query("select * from Produce")
    fun get_all(): List<Produce>

}