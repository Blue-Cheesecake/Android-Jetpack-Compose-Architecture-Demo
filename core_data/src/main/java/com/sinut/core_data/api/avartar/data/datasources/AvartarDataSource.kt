package com.sinut.core_data.api.avartar.data.datasources

import com.sinut.core_data.api.avartar.data.models.AvartarResponseModel
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel

interface AvartarDataSource {
    suspend fun findAll(queries: FindAllAvartarQueriesRequestModel): AvartarResponseModel
}