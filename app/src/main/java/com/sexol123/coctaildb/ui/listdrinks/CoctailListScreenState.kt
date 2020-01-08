package com.sexol123.coctaildb.ui.listdrinks

sealed class CoctailListScreenState {
    object ShowDrinkDetail : CoctailListScreenState()
    object ShowLoading : CoctailListScreenState()
    object HideLoading : CoctailListScreenState()
}
