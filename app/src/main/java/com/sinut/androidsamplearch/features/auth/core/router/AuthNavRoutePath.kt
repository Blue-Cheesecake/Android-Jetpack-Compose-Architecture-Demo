package com.sinut.androidsamplearch.features.auth.core.router

import com.sinut.androidsamplearch.core.router.IAppRoutePath
import kotlinx.serialization.Serializable

sealed class AuthNavRoutePath {

    @Serializable
    object Login: IAppRoutePath {
        override val routeName: String
            get() = "login"
        override val path: String
            get() = "/login"
    }
}