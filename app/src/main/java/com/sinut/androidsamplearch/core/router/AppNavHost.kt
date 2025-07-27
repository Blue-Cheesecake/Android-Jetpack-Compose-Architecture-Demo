package com.sinut.androidsamplearch.core.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.core.router.adminDestination
import com.sinut.androidsamplearch.features.auth.core.router.AuthNavRoutePath
import com.sinut.androidsamplearch.features.auth.core.router.authDestination

interface INavAction

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController, startDestination = AuthNavRoutePath.Login) {
        authDestination(AdminNavActions(navController))
        adminDestination(AdminNavActions(navController))
    }
}