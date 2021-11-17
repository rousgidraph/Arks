package com.example.gidraph.database

import android.os.Handler
import android.os.Looper
import com.example.gidraph.Models.*
import com.example.gidraph.Models.views.merchant_score
import com.example.gidraph.Models.views.sale_score
import com.example.gidraph.Models.views.vet_score_view
import com.example.gidraph.daos.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    //these daos will be injected from the database module
    private var vetVisitDao: vet_visit_dao,
    private var vetDao: vet_dao,
    private var salesDao: sales_dao,
    private var produceDao: produce_dao,
    private var produce_type_dao: produce_type_dao,
    private var animalDao: animal_dao,
    private var merchantDao: merchant_dao,
    private var salesTypeDao: sales_type_dao,
    private var salesItemDao: sales_item_dao,
    private var vetIssueDao: vet_issue_dao
){
    //this method has all the database manipulation calls
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


    fun add_sale(sale: Sale,callback: (Long) -> Unit){
        executorService.execute {
            var num = salesDao.insert(sale)
            mainThreadHandler.post { callback(num) }
        }
    }

    fun get_sale_types(callback: (List<sale_type>) -> Unit){
        executorService.execute {
            var returnable = salesTypeDao.get_sale_types()
            mainThreadHandler.post { callback(returnable) }
        }
    }

    fun add_sale_items(saleItem: sale_item){
        executorService.execute {
            salesItemDao.insert(saleItem)
        }
    }

    fun add_vet_visit(vetVisit: Vet_visit, callback: (Long) -> Unit){
        executorService.execute {
            var value = vetVisitDao.insert(vetVisit)
            mainThreadHandler.post { callback(value) }
        }

    }
    fun add_vet_visit_issues(vetIssue: Vet_issue){
        executorService.execute {
            vetIssueDao.insert(vetIssue)
        }

    }

    fun add_produce_type(produceType: produce_type){
        executorService.execute {
            produce_type_dao.insert(produceType)
        }
    }

    fun get_produce_type(callback: (List<produce_type>) -> Unit){
        executorService.execute {
            var temp = produce_type_dao.get_all_prod_types()
            mainThreadHandler.post { callback(temp) }
        }
    }

    fun add_produce(produce: Produce){
        executorService.execute {
            produceDao.insert(produce)
        }
    }

    fun load_type_score(callback: (List<sale_score>) -> Unit){
        executorService.execute {
            var temp = salesTypeDao.load_type_score()
            mainThreadHandler.post { callback(temp) }
        }
    }

    fun load_vet_score(callback: (List<vet_score_view>) -> Unit){
        executorService.execute {
            var temp = vetDao.load_vet_score()
            mainThreadHandler.post {
                callback(temp)
            }
        }
    }

    fun load_merchant_score(callback: (List<merchant_score>) -> Unit){
           executorService.execute {
               var temp = merchantDao.load_merchant_score()
               mainThreadHandler.post {
                   callback(temp)
               }
           }
    }

    fun load_all_produce(callback: (List<Produce>) -> Unit){
        executorService.execute {
            var temp = produceDao.get_all()
            mainThreadHandler.post {
                callback(temp)
            }
        }
    }

    fun load_all_sale(callback: (List<Produce>) -> Unit){
        executorService.execute {
            var temp = produceDao.get_all()
            mainThreadHandler.post {
                callback(temp)
            }
        }
    }

}