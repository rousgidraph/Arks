package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.gidraph.Models.Animal

@Dao
interface animal_dao : BaseDao<Animal> {
    /*
    * This interface doeals with animal transactions
    * */

    @Transaction
    @Query("Select * from Animal where id Like :ani_id")
    fun search_animal(ani_id : Long): List<Animal>


    @Transaction
    @Query("select * from Animal")
    fun load_all_animals(): List<Animal>

    @Transaction
    @Query("select * from Animal where breed Like :breed")
    fun load_by_breed(breed: String): List<Animal>

}