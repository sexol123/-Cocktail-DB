package com.sexol123.coctaildb.data.network.responce_model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkDetailed(
    @SerializedName("dateModified")
    val dateModified: String = "",
    @SerializedName("idDrink")
    val idDrink: String = "",
    @SerializedName("strAlcoholic")
    val strAlcoholic: String = "",
    @SerializedName("strCategory")
    val strCategory: String = "",
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String = "",
    @SerializedName("strDrink")
    val strDrink: String = "",
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: String = String(),
    @SerializedName("strDrinkDE")
    val strDrinkDE: String = String(),
    @SerializedName("strDrinkES")
    val strDrinkES: String = String(),
    @SerializedName("strDrinkFR")
    val strDrinkFR: String = String(),
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String = "",
    @SerializedName("strDrinkZH-HANS")
    val strDrinkZHHANS: String = String(),
    @SerializedName("strDrinkZH-HANT")
    val strDrinkZHHANT: String = String(),
    @SerializedName("strGlass")
    val strGlass: String = "",
    @SerializedName("strIBA")
    val strIBA: String = "",
    @SerializedName("strIngredient1")
    val strIngredient1: String = "",
    @SerializedName("strIngredient10")
    val strIngredient10: String = String(),
    @SerializedName("strIngredient11")
    val strIngredient11: String = String(),
    @SerializedName("strIngredient12")
    val strIngredient12: String = String(),
    @SerializedName("strIngredient13")
    val strIngredient13: String = String(),
    @SerializedName("strIngredient14")
    val strIngredient14: String = String(),
    @SerializedName("strIngredient15")
    val strIngredient15: String = String(),
    @SerializedName("strIngredient2")
    val strIngredient2: String = "",
    @SerializedName("strIngredient3")
    val strIngredient3: String = "",
    @SerializedName("strIngredient4")
    val strIngredient4: String = "",
    @SerializedName("strIngredient5")
    val strIngredient5: String = String(),
    @SerializedName("strIngredient6")
    val strIngredient6: String = String(),
    @SerializedName("strIngredient7")
    val strIngredient7: String = String(),
    @SerializedName("strIngredient8")
    val strIngredient8: String = String(),
    @SerializedName("strIngredient9")
    val strIngredient9: String = String(),
    @SerializedName("strInstructions")
    val strInstructions: String = "",
    @SerializedName("strInstructionsDE")
    val strInstructionsDE: String = "",
    @SerializedName("strInstructionsES")
    val strInstructionsES: String = String(),
    @SerializedName("strInstructionsFR")
    val strInstructionsFR: String = String(),
    @SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: String = String(),
    @SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: String = String(),
    @SerializedName("strMeasure1")
    val strMeasure1: String = "",
    @SerializedName("strMeasure10")
    val strMeasure10: String = String(),
    @SerializedName("strMeasure11")
    val strMeasure11: String = String(),
    @SerializedName("strMeasure12")
    val strMeasure12: String = String(),
    @SerializedName("strMeasure13")
    val strMeasure13: String = String(),
    @SerializedName("strMeasure14")
    val strMeasure14: String = String(),
    @SerializedName("strMeasure15")
    val strMeasure15: String = String(),
    @SerializedName("strMeasure2")
    val strMeasure2: String = "",
    @SerializedName("strMeasure3")
    val strMeasure3: String = "",
    @SerializedName("strMeasure4")
    val strMeasure4: String = String(),
    @SerializedName("strMeasure5")
    val strMeasure5: String = String(),
    @SerializedName("strMeasure6")
    val strMeasure6: String = String(),
    @SerializedName("strMeasure7")
    val strMeasure7: String = String(),
    @SerializedName("strMeasure8")
    val strMeasure8: String = String(),
    @SerializedName("strMeasure9")
    val strMeasure9: String = String(),
    @SerializedName("strTags")
    val strTags: String = ""
) : Drinks