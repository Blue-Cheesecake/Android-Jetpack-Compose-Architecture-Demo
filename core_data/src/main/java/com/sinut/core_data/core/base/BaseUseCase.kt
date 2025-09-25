package com.sinut.core_data.core.base

import UnknownException
import com.sinut.core_data.core.data.models.CommonErrorResponseModel
import kotlinx.serialization.json.Json
import retrofit2.HttpException

abstract class BaseUseCase<P, R> {

    protected abstract suspend fun call(params: P): R

    protected open fun finallyCb() {}

    suspend fun execute(params: P): Result<R> {
        val result = runCatching<R> {
            val response = call(params)
            response
        }.apply {
            finallyCb()
        }

        return result.onFailure {
            return handleException(it)
        }
    }

    private fun <T> handleException(e: Throwable): Result<T> {
        println("Error ka e here. $e")

        if (e is HttpException) {
            val errorBody = e.response()?.errorBody()

            val rawErrorString = errorBody?.string()

            if (rawErrorString != null) {
                val modelResult = runCatching<CommonErrorResponseModel> {
                    Json.decodeFromString<CommonErrorResponseModel>(rawErrorString)
                }

                modelResult
                    .onSuccess {
                        return Result.failure(Exception(it.message))
                    }
                    .onFailure {
                        return Result.failure(UnknownException())
                    }
            }
        }

        return Result.failure(e)
    }
}