package com.sinut.androidsamplearch.features.auth.presentation.pages

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginCard
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginEventListener
import com.sinut.androidsamplearch.features.auth.presentation.composables.SignUpTitle
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginApiViewModel

@Composable
fun LoginScreen(
    navActions: AdminNavActions,
    loginApiViewModel: LoginApiViewModel = hiltViewModel(),
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
            ) {
                Spacer(Modifier.weight(0.5F))
                Box(Modifier.padding(horizontal = 20.dp)) {
                    LoginCard(
                        onClickSignIn = {
                            localFocusManager.clearFocus()
                        }, onFormValid = {
                            loginApiViewModel.login(it.username, it.password)
                        }
                    )
                }
                Spacer(Modifier.weight(1F))
                SignUpTitle(onClickSignUp = {})
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}
