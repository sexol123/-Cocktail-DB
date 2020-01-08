package com.sexol123.coctaildb.ui.itemdetailed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sexol123.coctaildb.base.BaseViewModel
import com.sexol123.coctaildb.data.model.UiDrinkDetailed
import com.sexol123.coctaildb.domain.interactor.drink.DrinkInteractorImpl
import com.sexol123.coctaildb.ui.interactor.drink.IDrinkInteractor
import com.sexol123.coctaildb.ui.listdrinks.DrinkDetailedScreenState
import io.reactivex.schedulers.Schedulers

class DrinkDetailedViewModel : BaseViewModel() {
    private val drinkInteractor: IDrinkInteractor = DrinkInteractorImpl()
    val screenState = MutableLiveData<DrinkDetailedScreenState>()
    val drinkDetailed = MutableLiveData<UiDrinkDetailed>()

    fun getDetailedById(id: String) {
        drinkInteractor.loadDrinksDetailsById(id)
            .doOnSubscribe { screenState.postValue(DrinkDetailedScreenState.ShowLoading) }
            .doFinally { screenState.postValue(DrinkDetailedScreenState.HideLoading) }
            .subscribeOn(Schedulers.io())
            .subscribe({
                drinkDetailed.postValue(it)
            }, {
                Log.e("getDetailedById", it.localizedMessage, it.fillInStackTrace())
            }).also { mDisposables.add(it) }
    }
}
