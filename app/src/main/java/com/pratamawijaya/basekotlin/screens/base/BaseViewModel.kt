package com.pratamawijaya.basekotlin.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {


    override fun onCleared() {
        super.onCleared()
        d { "vm cleared" }
        viewModelScope.cancel()
    }

    abstract fun onError(error: Throwable)
}