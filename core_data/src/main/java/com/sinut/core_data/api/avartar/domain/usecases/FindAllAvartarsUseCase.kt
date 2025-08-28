package com.sinut.core_data.api.avartar.domain.usecases

import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel
import com.sinut.core_data.api.avartar.domain.repositories.AvartarRepository
import com.sinut.core_data.core.base.BaseUseCase
import javax.inject.Inject

class FindAllAvartarsUseCase @Inject constructor(private val repository: AvartarRepository) :
    BaseUseCase<FindAllAvartarQueriesRequestModel, List<AvartarInfoModel>>() {

    override suspend fun call(params: FindAllAvartarQueriesRequestModel): List<AvartarInfoModel> {
        return repository.findAll(params)
    }
}