package com.sexol123.coctaildb.ui.listdrinks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sexol123.coctaildb.base.BaseViewModel
import com.sexol123.coctaildb.data.model.UiDrinkBase
import com.sexol123.coctaildb.data.model.UiDrinkCategory
import com.sexol123.coctaildb.data.model.UiDrinkItem
import com.sexol123.coctaildb.domain.interactor.drink.DrinkInteractorImpl
import com.sexol123.coctaildb.ui.interactor.drink.IDrinkInteractor
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

class CocktailListViewModel: BaseViewModel() {
    private val tag = this::class.java.simpleName
    private val drinkInteractor: IDrinkInteractor by lazy { DrinkInteractorImpl() }
    val screenState = MutableLiveData<CoctailListScreenState>()
    val mUpdateData = MutableLiveData<List<UiDrinkBase>>()


    private fun getDrinksByCategory(
        category: UiDrinkCategory,
        onSuccess: (List<UiDrinkItem>) -> Unit
    ) {
        drinkInteractor.loadDrinksByCategory(category.title)
            .subscribeOn(Schedulers.io())
            .subscribe({
                onSuccess.invoke(it)
            }, ::onError).also { mDisposables.add(it) }
    }

    fun getAllCategoryAndDrinksAsListToUi() {
        val listFinal = LinkedList<UiDrinkBase>()
        drinkInteractor.loadDrinksCategory().subscribeOn(Schedulers.io())
            .doOnSubscribe { screenState.postValue(CoctailListScreenState.ShowLoading) }
            .flatMapObservable {
                Observable.fromIterable(it)
            }
            .concatMapSingle { category ->
                listFinal.add(category)
                drinkInteractor.loadDrinksByCategory(category.title)
            }
            .collect({ listFinal }, { list, items -> list.addAll(items) })
            .doFinally { screenState.postValue(CoctailListScreenState.HideLoading) }
            .subscribe({
                mUpdateData.postValue(it)
            }, ::onError).also { mDisposables.add(it) }
    }


    private fun onError(it: Throwable){
        Log.d(tag, it.localizedMessage , it.fillInStackTrace())
    }

    fun goToDetailedScreen() {
        screenState.value = CoctailListScreenState.ShowDrinkDetail
    }

    fun cleanState() {
        screenState.value = null
    }
}