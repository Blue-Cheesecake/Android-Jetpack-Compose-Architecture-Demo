package com.sinut.core_data.api.avartar.domain.repositories

import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel

interface AvartarRepository {
    suspend fun findAll(): List<AvartarInfoModel>
}