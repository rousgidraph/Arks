package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Vet
import com.example.gidraph.Models.views.vet_score_view

@Dao
interface vet_dao : BaseDao<Vet> {
    /*
    * vet database transactions
    * */


    @Transaction
    @Query("Select * from Vet")
    fun load_vets() : List<Vet>

    @Transaction
    @Query("select * from vet_score_view")
    fun load_vet_score():List<vet_score_view>
}

