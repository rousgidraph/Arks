package com.example.gidraph.database

import android.os.Handler
import android.os.Looper
import com.example.gidraph.Models.Animal
import com.example.gidraph.Models.Merchant
import com.example.gidraph.Models.Vet
import com.example.gidraph.Models.sale_type
import com.example.gidraph.daos.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    //daos
    private var vetVisitDao: vet_visit_dao,
    private var vetDao: vet_dao,
    private var salesDao: sales_dao,
    private var produceDao: produce_dao,
    private var animalDao: animal_dao,
    private var merchantDao: merchant_dao,
    private var salesTypeDao: sales_type_dao
){
    private val executorService : ExecutorService = Executors.newFixedThreadPool(5)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }

    fun addanimal(ani : Animal){
        executorService.execute{
            animalDao.insert(ani)
        }
    }

    fun load_vets(callback: (List<Vet>) -> Unit){
        executorService.execute{
            var returnable = vetDao.load_vets()
            mainThreadHandler.post { callback(returnable) }
        }

    }

    fun add_vet(vet: Vet){
        executorService.execute{
            vetDao.insert(vet)
        }
    }

    fun add_merchant(merch: Merchant){
        executorService.execute{
            merchantDao.insert(merch)
        }
    }

    fun load_merchs(callback: (List<Merchant>) -> Unit){
        executorService.execute{
            var returnable =  merchantDao.load_merchants()
            mainThreadHandler.post { callback(returnable) }
        }
    }


    fun add_sale_type(saleType: sale_type){
        executorService.execute {
            salesTypeDao.insert(saleType)
        }
    }

    fun get_sale_types(callback: (List<sale_type>) -> Unit){
        executorService.execute {
            var returnable = salesTypeDao.get_sale_types()
            mainThreadHandler.post { callback(returnable) }
        }
    }
}