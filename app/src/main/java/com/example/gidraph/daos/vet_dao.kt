package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Vet

@Dao
interface vet_dao : BaseDao<Vet> {
    /*
    * vet database transactions
    * */


    @Transaction
    @Query("Select * from Vet")
    fun load_vets() : List<Vet>
}