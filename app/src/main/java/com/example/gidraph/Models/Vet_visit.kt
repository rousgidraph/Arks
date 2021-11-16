package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vet_visit(var date : String, var vet_id : Long, var total_fee : Double) {
    @PrimaryKey(autoGenerate = true)
    var visit_id : Long = 0
}