package com.example.gidraph.Models.views

import androidx.room.DatabaseView


@DatabaseView("select name , count(visit_id)'total'  from Vet, vet_visit where vet_id = id group by vet_id")
data class vet_score_view (var name:String , var total:Long)