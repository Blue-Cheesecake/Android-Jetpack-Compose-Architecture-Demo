package com.sinut.androidsamplearch.features.admin.core.router

import com.sinut.androidsamplearch.core.router.IAppRoutePath
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs
import kotlinx.serialization.Serializable

@Serializable
object AdminListRoute : IAppRoutePath {
    override val routeName: String
        get() = "admin-list"
    override val path: String
        get() = "/admin-list"
}

@Serializable
data class AdminDetailsRoute(val params: AdminDetailsScreenArgs)