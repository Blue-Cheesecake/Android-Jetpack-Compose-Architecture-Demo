package com.sinut.androidsamplearch.features.auth.router

import com.sinut.androidsamplearch.core.router.IdentifiableScreen
import kotlinx.serialization.Serializable

sealed class AuthNavRoutePath {

    @Serializable
    object Login : IdentifiableScreen {
        override val routeName: String
            get() = "login"
    }
}