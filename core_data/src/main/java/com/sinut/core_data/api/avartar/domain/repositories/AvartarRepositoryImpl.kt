package com.sinut.core_data.api.avartar.domain.repositories

import com.sinut.core_data.api.avartar.data.datasources.AvartarDataSource
import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel
import javax.inject.Inject

class AvartarRepositoryImpl @Inject constructor(private val dataSource: AvartarDataSource) : AvartarRepository {
    override suspend fun findAll(): List<AvartarInfoModel> {
        val response = dataSource.findAll()
        return response.avartars
    }
}