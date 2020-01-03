package com.sexol123.coctaildb.ui.itemdetailed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sexol123.coctaildb.base.BaseViewModel
import com.sexol123.coctaildb.domain.interactor.drink.DrinkInteractorImpl
import com.sexol123.coctaildb.ui.interactor.drink.IDrinkInteractor
import io.reactivex.schedulers.Schedulers

class DrinkDetailedViewModel : BaseViewModel() {
    private val drinkInteractor: IDrinkInteractor = DrinkInteractorImpl()
    val drinkDetailed = MutableLiveData<String>()

    fun getDetailedById(id: String) {
        drinkInteractor.loadDrinksDetailsById(id)
            .subscribeOn(Schedulers.io())
            .subscribe({
                drinkDetailed.postValue(it[0].toString())
            }, {
                Log.e("getDetailedById", it.localizedMessage, it.fillInStackTrace())
            }).also { mDisposables.add(it) }
    }
}
