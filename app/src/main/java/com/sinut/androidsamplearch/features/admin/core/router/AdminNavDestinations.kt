package com.sinut.androidsamplearch.features.admin.core.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.sinut.androidsamplearch.core.router.parcelableType
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs
import com.sinut.androidsamplearch.features.admin.details.presentation.pages.AdminDetailsScreen
import com.sinut.androidsamplearch.features.admin.list.presentation.pages.AdminListScreen
import kotlin.reflect.typeOf

fun NavGraphBuilder.adminDestination(navActions: AdminNavActions) {
    composable<AdminListRoute> { AdminListScreen(navActions) }

    composable<AdminDetailsRoute>(
        typeMap = mapOf(
            typeOf<AdminDetailsScreenArgs>() to parcelableType<AdminDetailsScreenArgs>()
        )
    ) {
        val route = it.toRoute<AdminDetailsRoute>()
        AdminDetailsScreen(route.params, navActions)
    }
}
