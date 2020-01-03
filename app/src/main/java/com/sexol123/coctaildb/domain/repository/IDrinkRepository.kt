package com.sexol123.coctaildb.domain.repository

import com.sexol123.coctaildb.data.model.UiDrinkItem
import com.sexol123.coctaildb.data.network.responce_model.DrinkCategory
import com.sexol123.coctaildb.data.network.responce_model.DrinkDetailed
import io.reactivex.Single

interface IDrinkRepository {
    fun getAllDrinksCategory(): Single<List<DrinkCategory>>
    fun getAllDrinksByCategory(filter: String): Single<List<UiDrinkItem>>
    fun getDrinksDetaildById(id: String): Single<List<DrinkDetailed>>
}