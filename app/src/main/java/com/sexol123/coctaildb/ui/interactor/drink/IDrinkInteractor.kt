package com.sexol123.coctaildb.ui.interactor.drink

import com.sexol123.coctaildb.data.model.UiDrinkCategory
import com.sexol123.coctaildb.data.model.UiDrinkDetailed
import com.sexol123.coctaildb.data.model.UiDrinkItem
import io.reactivex.Single

interface IDrinkInteractor {
    fun loadDrinksCategory(): Single<List<UiDrinkCategory>>
    fun loadDrinksByCategory(categoryName: String): Single<List<UiDrinkItem>>
    fun loadDrinksDetailsById(id: String): Single<UiDrinkDetailed>
}