package com.sinut.androidsamplearch.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T>(initState: T) : ViewModel() {

    private val _uiState = MutableStateFlow(initState)

    val uiState: StateFlow<T>
        get() = _uiState

    protected fun setState(s: T) {
        _uiState.value = s
    }
}