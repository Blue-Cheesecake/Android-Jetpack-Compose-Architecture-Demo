package com.sinut.androidsamplearch.features.admin.list.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.theme.AppTypography
import com.sinut.androidsamplearch.core.session.AppSession
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.details.data.models.AdminDetailsModel
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminListScreen(
    navActions: AdminNavActions
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Home", style = LocalTextStyle.current.copy(
                            fontSize = AppTypography.titleSmall.fontSize
                        )
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text("Hello from Admin Screen")
            Text("My App Session: ${AppSession.userSession?.token}")

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