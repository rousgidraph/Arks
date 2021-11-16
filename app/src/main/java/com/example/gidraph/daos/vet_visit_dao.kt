package com.example.gidraph.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.gidraph.Models.Vet_visit

@Dao
interface vet_visit_dao {

    @Update
    fun update( obj: Vet_visit)

    @Delete
    fun delete(obj: Vet_visit)

    @Insert
    fun insert(obj: Vet_visit) : Long
}