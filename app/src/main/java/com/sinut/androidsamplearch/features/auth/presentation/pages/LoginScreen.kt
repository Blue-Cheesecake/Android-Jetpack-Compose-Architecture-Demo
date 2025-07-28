package com.sinut.androidsamplearch.features.auth.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sinut.androidsamplearch.BuildConfig
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions

@Composable
fun LoginScreen(
    navActions: AdminNavActions
) {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text("Hello from Auth Screen: with env: ${BuildConfig.FLAVOR}")

            Button({
                navActions.goToAdminList()
            }) { Text("Go to admin list") }
        }
    }
}