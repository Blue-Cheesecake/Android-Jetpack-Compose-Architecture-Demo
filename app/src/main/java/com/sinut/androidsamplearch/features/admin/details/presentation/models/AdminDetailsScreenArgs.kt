package com.sinut.androidsamplearch.features.admin.details.presentation.models

import android.os.Parcelable
import com.sinut.androidsamplearch.features.admin.details.data.models.AdminDetailsModel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class AdminDetailsScreenArgs(
    val name: String,
    val num: Int,
    val admin: AdminDetailsModel
) : Parcelable
