package com.sinut.androidsamplearch.core.router

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun <T : IdentifiableScreen> NavController.trackAndNavigateTo(
    route: T,
    navOptions: NavOptions? = null,
    navigationExtras: Navigator.Extras? = null,
) {
    Log.i("NAV", "track message route: ${route.routeName}")
    this.navigate(route, navOptions, navigationExtras)
}