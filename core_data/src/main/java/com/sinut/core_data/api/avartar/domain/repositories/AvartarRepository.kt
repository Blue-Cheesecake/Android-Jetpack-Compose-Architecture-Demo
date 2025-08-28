package com.sinut.core_data.api.avartar.domain.repositories

import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel

interface AvartarRepository {
    suspend fun findAll(queries: FindAllAvartarQueriesRequestModel): List<AvartarInfoModel>
}