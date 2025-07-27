package com.sinut.androidsamplearch.features.admin.core.router

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.sinut.androidsamplearch.core.router.INavAction
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

class AdminNavActions(private val navController: NavHostController) : INavAction {

    fun goToAdminList() {
        navController.navigate(AdminListRoute) {
            popUpTo(navController.graph.findStartDestination().id) {
                inclusive = true
                saveState = false
            }
        }
    }

    fun pushToAdminDetails(params: AdminDetailsScreenArgs) {
        navController.navigate(AdminDetailsRoute(params))
    }
}