package com.sinut.core_data.api.avartar.domain.repositories

import com.sinut.core_data.api.avartar.data.datasources.AvartarDataSource
import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel
import javax.inject.Inject

class AvartarRepositoryImpl @Inject constructor(private val dataSource: AvartarDataSource) : AvartarRepository {
    override suspend fun findAll(queries: FindAllAvartarQueriesRequestModel): List<AvartarInfoModel> {
        val response = dataSource.findAll(queries)
        return response.avartars
    }
}