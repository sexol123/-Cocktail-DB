package com.sexol123.coctaildb.data.network

import com.sexol123.coctaildb.data.network.responce_model.DrinkCategory
import com.sexol123.coctaildb.data.network.responce_model.DrinkDetailed
import com.sexol123.coctaildb.data.network.responce_model.DrinkItem
import com.sexol123.coctaildb.data.network.responce_model.DrinksList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IRequestApi {

    @GET("api/json/v1/1/filter.php")
    fun loadDrinksByCategory(@Query("c") type: String): Single<DrinksList<DrinkItem>>

    @GET("api/json/v1/1/list.php?c=list")
    fun loadAllDrinksCategory(): Single<DrinksList<DrinkCategory>>

    @GET("api/json/v1/1/lookup.php")
    fun getCoctailById(@Query("i") type: String): Single<DrinksList<DrinkDetailed>>
}