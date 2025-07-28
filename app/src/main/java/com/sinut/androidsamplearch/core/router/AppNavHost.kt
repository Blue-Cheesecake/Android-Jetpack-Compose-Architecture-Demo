package com.sinut.androidsamplearch.core.router

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.core.router.adminDestination
import com.sinut.androidsamplearch.features.auth.core.router.AuthNavRoutePath
import com.sinut.androidsamplearch.features.auth.core.router.authDestination
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

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

inline fun <reified T : Parcelable> parcelableType(
    isNullableAllowed: Boolean = false,
    json: Json = Json,
) = object : NavType<T>(isNullableAllowed = isNullableAllowed) {
    override fun get(bundle: Bundle, key: String) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, T::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }

    override fun parseValue(value: String): T = json.decodeFromString(value)

    override fun serializeAsValue(value: T): String = Uri.encode(json.encodeToString(value))

    override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}