package com.sexol123.coctaildb.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel(){
    protected val mDisposables = CompositeDisposable()

    override fun onCleared() {
        mDisposables.clear()
        super.onCleared()
    }
}