package com.sinut.core_data.api.avartar.domain.usecases

import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel
import com.sinut.core_data.api.avartar.domain.repositories.AvartarRepository
import com.sinut.core_data.core.base.BaseUseCase
import javax.inject.Inject

class FindAllAvartarsUseCase @Inject constructor(private val repository: AvartarRepository) :
    BaseUseCase<Unit, List<AvartarInfoModel>>() {

    override suspend fun call(params: Unit): List<AvartarInfoModel> {
        return repository.findAll()
    }
}