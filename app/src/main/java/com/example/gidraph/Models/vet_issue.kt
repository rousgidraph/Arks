package com.example.gidraph.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class vet_issue(var visit_id: Long? =0 , var summary : String , var descripton :String?="" ){
    @PrimaryKey(autoGenerate = true)
    var issue_id : Long = 0
}
