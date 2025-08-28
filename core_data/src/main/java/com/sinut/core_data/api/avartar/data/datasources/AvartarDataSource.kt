package com.sinut.core_data.api.avartar.data.datasources

import com.sinut.core_data.api.avartar.data.models.AvartarResponseModel

interface AvartarDataSource {
    suspend fun findAll(): AvartarResponseModel
}