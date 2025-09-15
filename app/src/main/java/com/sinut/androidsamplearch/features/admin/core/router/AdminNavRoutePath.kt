package com.sinut.androidsamplearch.features.admin.core.router

import com.sinut.androidsamplearch.core.router.IdentifiableScreen
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs
import kotlinx.serialization.Serializable

@Serializable
object AdminListRoute : IdentifiableScreen {
    override val routeName: String get() = "admin-list"
}

@Serializable
data class AdminDetailsRoute(val params: AdminDetailsScreenArgs) : IdentifiableScreen {
    override val routeName: String get() = "admin-details"
}