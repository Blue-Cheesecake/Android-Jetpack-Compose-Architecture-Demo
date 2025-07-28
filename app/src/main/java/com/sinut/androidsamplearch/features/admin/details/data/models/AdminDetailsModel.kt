package com.sinut.androidsamplearch.features.admin.details.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class AdminDetailsModel(val id: Int, val position: String) : Parcelable