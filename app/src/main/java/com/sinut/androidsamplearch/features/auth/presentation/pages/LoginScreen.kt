package com.sinut.androidsamplearch.features.auth.presentation.pages

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sinut.androidsamplearch.BuildConfig
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginEventListener
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginFormFields
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginApiViewModel
import com.sinut.androidsamplearch.features.auth.presentation.logic.input.LoginInputViewModel
import com.sinut.androidsamplearch.features.auth.presentation.logic.validation.LoginValidationViewModel
import com.sinut.androidsamplearch.ui.theme.Purple80

@Composable
fun LoginScreen(
    navActions: AdminNavActions,
    loginApiViewModel: LoginApiViewModel = hiltViewModel(),
    loginInputViewModel: LoginInputViewModel = viewModel(),
    loginValidationViewModel: LoginValidationViewModel = viewModel(),
) {
    val localFocusManager = LocalFocusManager.current

    LoginEventListener(navActions, loginApiViewModel) {
        Scaffold { innerPadding ->
            Column(Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                    })
                }
                .padding(innerPadding)
                .padding(horizontal = 12.dp)

            ) {
                Text("Hello from Auth Screen: with env: ${BuildConfig.FLAVOR}")
                Spacer(Modifier.height(24.dp))
                LoginFormFields(loginInputViewModel, loginValidationViewModel)
                Spacer(Modifier.height(50.dp))

                ElevatedButton(
                    onClick = {
                        localFocusManager.clearFocus()

                        val input = loginInputViewModel.uiState.value
                        val isFormValid = loginValidationViewModel.validate(loginInputViewModel.uiState.value)

                        if (isFormValid) {
                            loginApiViewModel.login(input.username, input.password)
                        }
                    },
                    shape = RoundedCornerShape(8),
                    colors = ButtonDefaults.elevatedButtonColors().copy(
                        containerColor = Purple80
                    ),
                    elevation = null,
                ) {
                    Text("Sign In")
                }
            }
        }
    }
}