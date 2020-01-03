package com.sexol123.coctaildb.data.repository.drink

import com.sexol123.coctaildb.data.model.UiDrinkItem
import com.sexol123.coctaildb.data.network.ApiService
import com.sexol123.coctaildb.data.network.IRequestApi
import com.sexol123.coctaildb.data.network.responce_model.DrinkCategory
import com.sexol123.coctaildb.data.network.responce_model.DrinkDetailed
import com.sexol123.coctaildb.domain.repository.IDrinkRepository
import io.reactivex.Single

class DrinkRepositoryImpl: IDrinkRepository {

    private val service : IRequestApi = ApiService().getInstance()
    private val mapper = DrinkMapper()

    override fun getAllDrinksCategory(): Single<List<DrinkCategory>> {
        return service.loadAllDrinksCategory()
            .map { response -> return@map mapper.mapCategory(response) }
    }

    override fun getAllDrinksByCategory(filter: String): Single<List<UiDrinkItem>>{
        return service.loadDrinksByCategory(filter)
            .map { response -> return@map mapper.mapDrink(response) }
    }

    override fun getDrinksDetaildById(id: String): Single<List<DrinkDetailed>> {
        return service.getCoctailById(id)
            .map { response -> response.drinks.orEmpty() }
    }
}