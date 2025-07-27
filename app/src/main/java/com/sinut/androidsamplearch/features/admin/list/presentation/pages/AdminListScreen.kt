package com.sinut.androidsamplearch.features.admin.list.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

@Composable
fun AdminListScreen(
    navActions: AdminNavActions
) {
    Scaffold { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text("Hello from Admin Screen")

            Button(onClick = {
                navActions.pushToAdminDetails(AdminDetailsScreenArgs("Sprite", 45))
            }) {
                Text("Push to Details")
            }
        }
    }
}