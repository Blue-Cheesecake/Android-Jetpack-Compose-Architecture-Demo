package com.sinut.androidsamplearch.features.admin.details.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.dropUnlessResumed
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDetailsScreen(
    params: AdminDetailsScreenArgs,
    navActions: AdminNavActions,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = dropUnlessResumed {
                        navActions.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                title = { Text("Details") },
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Text("Hello from Admin Details Screen")
            Text("My name is ${params.name} with ${params.num}")
            Text("Employee ID: ${params.admin.id}, position: ${params.admin.position}")
        }
    }
}