package com.sinut.androidsamplearch.features.auth.presentation.pages

import LoginInputViewModel
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun LoginScreen(
    navActions: AdminNavActions,
    loginApiViewModel: LoginApiViewModel = hiltViewModel(),
    loginInputViewModel: LoginInputViewModel = viewModel(),
) {
    val localFocusManager = LocalFocusManager.current

    LoginEventListener(navActions, loginApiViewModel) {
        Scaffold { innerPadding ->
            Column(
                Modifier
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
                LoginFormFields(loginInputViewModel)
            }
        }
    }
}