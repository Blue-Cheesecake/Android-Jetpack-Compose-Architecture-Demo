package com.sinut.androidsamplearch.features.auth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinut.androidsamplearch.common.composables.CommonDialog
import com.sinut.androidsamplearch.core.session.AppSession
import com.sinut.androidsamplearch.core.session.data.models.UserSessionModel
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginApiState
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginApiViewModel

@Composable
fun LoginEventListener(
    navActions: AdminNavActions,
    loginViewModel: LoginApiViewModel,
    child: @Composable () -> Unit,
) {
    val loginApiState = loginViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(loginApiState.value) {
        when (loginApiState.value) {
            is LoginApiState.Success -> {
                val s = loginApiState.value as LoginApiState.Success

                loginViewModel.invalidate()
                AppSession.userSession = UserSessionModel(s.token)

                navActions.goToAdminList()
            }

            else -> Unit
        }
    }

    child()

    when (loginApiState.value) {
        LoginApiState.Loading -> Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5F))
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) {},
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        is LoginApiState.Error -> {
            val errMsg = (loginApiState.value as LoginApiState.Error).message

            CommonDialog(
                onDismissRequest = { loginViewModel.invalidate() },
                onConfirmation = { loginViewModel.invalidate() },
                dialogTitle = "Error",
                dialogText = errMsg,
            )
        }

        else -> Unit
    }
}