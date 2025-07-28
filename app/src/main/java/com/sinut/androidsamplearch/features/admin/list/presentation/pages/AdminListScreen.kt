package com.sinut.androidsamplearch.features.admin.list.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.details.data.models.AdminDetailsModel
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

@Composable
fun AdminListScreen(
    navActions: AdminNavActions
) {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text("Hello from Admin Screen")

            Spacer(Modifier.height(12.dp))

            Button(onClick = {
                navActions.pushToAdminDetails(
                    AdminDetailsScreenArgs(
                        "Sprite", 45, AdminDetailsModel(
                            id = 1,
                            position = "Engineer"
                        )
                    )
                )
            }) {
                Text("Push to Details")
            }
        }
    }
}