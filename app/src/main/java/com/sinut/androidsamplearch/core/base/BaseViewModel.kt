package com.sinut.androidsamplearch.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<T>(initState: T) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)
    val uiState: StateFlow<T> = _uiState

    protected fun setState(s: T) {
        _uiState.value = s
    }

    protected fun setState(function: (T) -> T) {
        _uiState.update(function)
    }
}