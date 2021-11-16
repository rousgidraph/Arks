package com.example.gidraph.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gidraph.Models.*
import com.example.gidraph.Models.views.merchant_score
import com.example.gidraph.Models.views.sale_score
import com.example.gidraph.Models.views.vet_score_view
import com.example.gidraph.daos.*


@Database(
    entities = arrayOf(
        Animal::class,
        Medicine_details::class,
        Merchant::class,
        Produce::class,
        produce_type::class,
        Sale::class,
        sale_item::class,
        sale_type::class,
        Vet::class,
        Vet_issue::class,
        Vet_visit::class),//the entitiy classes
    views = arrayOf(
        merchant_score::class,
        sale_score::class,
        vet_score_view::class
    ),//the views you want in the database
    version = 1,
    exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    /*
    * declare the daos here
    * */

    abstract fun animal_dao() : animal_dao
    abstract fun medicine_dao() : medicine_dao
    abstract fun produce_dao() : produce_dao
    abstract fun sales_dao() : sales_dao
    abstract fun vet_dao() : vet_dao
    abstract fun vet_visit_dao() : vet_visit_dao
    abstract fun merchant_dao() : merchant_dao
    abstract fun sale_type_dao() : sales_type_dao
    abstract fun sales_item_dao() : sales_item_dao
    abstract fun vet_issue_dao() : vet_issue_dao
    abstract fun produce_type_dao() : produce_type_dao



}