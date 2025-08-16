package com.sinut.core_data.core.base

import com.sinut.core_data.core.data.models.CommonErrorResponseModel
import kotlinx.serialization.json.Json
import retrofit2.HttpException

abstract class BaseUseCase<P, R> {

    protected abstract suspend fun call(params: P): R

    suspend fun execute(params: P): Result<R> {
        val result = runCatching<R> {
            val response = call(params)
            return Result.success(response)
        }

        return result
            .onFailure {
                return handleException(it)
            }
            .onSuccess {
                return result
            }
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