package com.sexol123.coctaildb.data.repository.drink

import com.sexol123.coctaildb.data.model.UiDrinkItem
import com.sexol123.coctaildb.data.network.responce_model.DrinkCategory
import com.sexol123.coctaildb.data.network.responce_model.DrinkItem
import com.sexol123.coctaildb.data.network.responce_model.DrinksList

class DrinkMapper {

    fun mapCategory(response: DrinksList<DrinkCategory>): List<DrinkCategory> {
        return response.drinks ?: listOf()
    }

    fun mapDrink(response: DrinksList<DrinkItem>): List<UiDrinkItem> {
        val mapList = mutableListOf<UiDrinkItem>()
        response.drinks?.forEach { item ->
            mapList.add(
                UiDrinkItem(
                    item.strDrink ?: "",
                    item.strDrinkThumb ?: "",
                    item.idDrink ?: ""
                )
            )
        }
        return mapList
    }
}