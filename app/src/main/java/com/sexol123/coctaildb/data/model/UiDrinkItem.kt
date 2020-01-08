package com.sexol123.coctaildb.data.model

abstract class UiDrinkBase

data class UiDrinkItem(
    val title: String,
    val imgSrc: String,
    val idDrink: String = ""
) : UiDrinkBase()

data class UiDrinkCategory(val title: String) : UiDrinkBase()