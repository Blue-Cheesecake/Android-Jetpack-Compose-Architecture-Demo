package com.sinut.androidsamplearch.features.auth.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PanoramaFishEye
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinut.androidsamplearch.common.composables.CommonTextField
import com.sinut.androidsamplearch.features.auth.presentation.logic.input.LoginInputViewModel
import com.sinut.androidsamplearch.features.auth.presentation.logic.validation.LoginValidationViewModel

@Composable
fun LoginFormFields(inputViewModel: LoginInputViewModel, validationViewModel: LoginValidationViewModel) {
    val inputState = inputViewModel.uiState.collectAsStateWithLifecycle()
    val validationState = validationViewModel.uiState.collectAsStateWithLifecycle()

    var isPasswordHidden by rememberSaveable { mutableStateOf(true) }

    CommonTextField(
        value = inputState.value.username,
        onValueChange = {
            inputViewModel.updateUsername(it)
        },
        placeHolder = "Username",
        errorText = validationState.value.usernameErrorText,
    )
    Spacer(Modifier.height(12.dp))
    CommonTextField(
        value = inputState.value.password,
        onValueChange = {
            inputViewModel.updatePassword(it)
        },
        placeHolder = "Password",
        errorText = validationState.value.passwordErrorText,
        hideText = isPasswordHidden,
        suffix = {
            Icon(
                imageVector = if (isPasswordHidden) Icons.Filled.RemoveRedEye else Icons.Filled.PanoramaFishEye,
                contentDescription = null,
                modifier = Modifier
                    .clickable { isPasswordHidden = !isPasswordHidden }
            )
        }
    )
}