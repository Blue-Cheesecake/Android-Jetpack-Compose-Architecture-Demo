package com.sinut.core_data.api.avartar.data.models

import com.sinut.core_data.api.avartar.constants.AvartarStatus

data class AvartarResponseModel(
    val avartars: List<AvartarInfoModel>
)

data class AvartarInfoModel(
    val id: String,
    val fullName: String,
    val status: AvartarStatus,
    val imageUrl: String
)