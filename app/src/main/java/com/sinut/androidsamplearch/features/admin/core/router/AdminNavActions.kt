package com.sinut.androidsamplearch.features.admin.core.router

import androidx.navigation.NavHostController
import com.sinut.androidsamplearch.core.router.INavAction
import com.sinut.androidsamplearch.core.router.trackAndNavigateTo
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs

class AdminNavActions(private val navController: NavHostController) : INavAction {

    fun goToAdminList() {
        navController.trackAndNavigateTo(AdminListRoute)
    }

    fun pushToAdminDetails(params: AdminDetailsScreenArgs) {
        navController.trackAndNavigateTo(AdminDetailsRoute(params))
    }

    fun popBackStack() {
        navController.popBackStack()

    }
}