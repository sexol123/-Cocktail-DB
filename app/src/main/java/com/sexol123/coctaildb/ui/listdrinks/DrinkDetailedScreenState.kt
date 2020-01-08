package com.sexol123.coctaildb.ui.listdrinks

sealed class DrinkDetailedScreenState {
    object HideLoading : DrinkDetailedScreenState()
    object ShowLoading : DrinkDetailedScreenState()
}