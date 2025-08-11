package com.sinut.androidsamplearch.features.auth.presentation.composables

import LoginInputViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sinut.androidsamplearch.common.composables.CommonTextField

@Composable
fun LoginFormFields(inputViewModel: LoginInputViewModel) {
    val state = inputViewModel.uiState.collectAsState()

    CommonTextField(
        value = state.value.username,
        onValueChange = {
            inputViewModel.updateUsername(it)
        },
        placeHolder = "Username"
    )
    Spacer(Modifier.height(12.dp))
    CommonTextField(
        value = state.value.password,
        onValueChange = {
            inputViewModel.updatePassword(it)
        },
        placeHolder = "Password"
    )
}