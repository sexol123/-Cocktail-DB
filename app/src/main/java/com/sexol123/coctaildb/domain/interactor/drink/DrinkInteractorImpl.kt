package com.sexol123.coctaildb.domain.interactor.drink

import com.sexol123.coctaildb.data.model.UiDrinkCategory
import com.sexol123.coctaildb.data.repository.drink.DrinkRepositoryImpl
import com.sexol123.coctaildb.domain.repository.IDrinkRepository
import com.sexol123.coctaildb.ui.interactor.drink.IDrinkInteractor
import io.reactivex.Single

class DrinkInteractorImpl(
    private val repository: IDrinkRepository = DrinkRepositoryImpl()
): IDrinkInteractor {

    override fun loadDrinksDetailsById(id: String) = repository
        .getDrinksDetaildById(id)

    override fun loadDrinksCategory(): Single<List<UiDrinkCategory>> = repository
        .getAllDrinksCategory().map {
            List(it.size){ index ->
                UiDrinkCategory(it[index].strCategory.orEmpty())
            }
        }

    override fun loadDrinksByCategory(categoryName: String) = repository
        .getAllDrinksByCategory(categoryName)
}