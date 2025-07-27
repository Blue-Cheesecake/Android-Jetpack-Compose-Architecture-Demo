package com.sinut.androidsamplearch.features.admin.details.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

@Composable
fun AdminDetailsScreen(
    params: AdminDetailsScreenArgs
) {
    Scaffold { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                Text("Hello from Admin Details Screen")
                Text("My name is ${params.name} with ${params.num}")
            }
        }
    }
}