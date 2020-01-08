package com.sexol123.coctaildb.data.model

data class UiDrinkDetailed(
    val dateModified: String = "",
    val idDrink: String = "",
    val strAlcoholic: String = "",
    val strCategory: String = "",
    val strCreativeCommonsConfirmed: String = "",
    val strDrinkAlternate: String = "",
    val strDrinkThumb: String = "",
    val strGlass: String = "",
    val strIBA: String = "",
    val strInstructions: String = "",
    val strTags: String = ""
) : UiDrinkBase()
