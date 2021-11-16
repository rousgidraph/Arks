package com.example.gidraph.di

import android.content.Context
import androidx.room.Room
import com.example.gidraph.Models.sale_type
import com.example.gidraph.daos.*
import com.example.gidraph.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext : Context): AppDatabase{
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "farm.db"
        ).build()
    }


    @Provides//you need such fro all the daos
    fun provides_animal_dao(database: AppDatabase) : animal_dao{
        return database.animal_dao()
    }
    @Provides
    fun provides_produce_dao(database: AppDatabase) : produce_dao{
        return database.produce_dao()
    }
    @Provides
    fun provides_vet_dao(database: AppDatabase) : vet_dao{
        return database.vet_dao()
    }
    @Provides
    fun provides_vet_visit(database: AppDatabase) : vet_visit_dao{
        return database.vet_visit_dao()
    }

    @Provides
    fun provides_medicine_dao(database: AppDatabase) : medicine_dao{
        return database.medicine_dao()
    }

    @Provides
    fun provides_merchant_dao(database: AppDatabase) : merchant_dao{
        return database.merchant_dao()
    }

    @Provides
    fun provides_sales_dao(database: AppDatabase): sales_dao{
        return database.sales_dao()
    }

    @Provides
    fun provides_sale_type_dao(database: AppDatabase): sales_type_dao{
        return database.sale_type_dao()
    }

}