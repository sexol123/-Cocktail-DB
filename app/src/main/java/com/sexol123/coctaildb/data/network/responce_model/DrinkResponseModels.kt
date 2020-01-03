package com.sexol123.coctaildb.data.network.responce_model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinksList<T: Drinks>(
        @SerializedName("drinks")
        var drinks: List<T>? = null
): Parcelable

@Parcelize
data class DrinkCategory (

    @SerializedName("strCategory")
    var strCategory: String? = null

): Drinks

@Parcelize
data class DrinkItem (
    @SerializedName("strDrink")
    var strDrink: String? = null,

    @SerializedName("strDrinkThumb")
    var strDrinkThumb: String? = null,

    @SerializedName("idDrink")
    var idDrink: String? = null

): Drinks

interface  Drinks: Parcelable