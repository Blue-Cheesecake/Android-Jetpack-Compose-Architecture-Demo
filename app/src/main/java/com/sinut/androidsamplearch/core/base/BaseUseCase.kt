package com.sinut.androidsamplearch.core.base

import com.sinut.androidsamplearch.common.data.models.CommonErrorResponseModel
import kotlinx.serialization.json.Json
import retrofit2.HttpException

abstract class BaseUseCase<P, R> {

    protected abstract suspend fun call(params: P): R

    suspend fun execute(params: P): Result<R> {
        val result = runCatching<R> {
            val response = call(params)
            return Result.success(response)
        }

        if (result.isFailure) {
            return result.onFailure { return handleException<R>(it) }
        }

        return result
    }

    private fun <T> handleException(e: Throwable): Result<T> {
        if (e is HttpException) {
            val errorBody = e.response()?.errorBody()

            val rawErrorString = errorBody?.string()

            if (rawErrorString != null) {
                val model = Json.decodeFromString<CommonErrorResponseModel>(rawErrorString)

                return Result.failure(Exception(model.message))
            }
        }

        return Result.failure(e)
    }
}