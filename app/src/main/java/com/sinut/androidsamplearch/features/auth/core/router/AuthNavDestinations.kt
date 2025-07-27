package com.sinut.androidsamplearch.features.auth.core.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.pages.LoginScreen

fun NavGraphBuilder.authDestination(adminNavActions: AdminNavActions) {
    composable<AuthNavRoutePath.Login> { LoginScreen(adminNavActions) }
}