package com.sinut.androidsamplearch.core.base

import retrofit2.HttpException

abstract class BaseUseCase<P, R> {

    protected abstract suspend fun call(params: P): R

    suspend fun execute(params: P): Result<R> {
        try {
            val response = call(params)
            return Result.success(response)
        } catch (e: HttpException) {
            // Will throw on non 2xx status
            return Result.failure(Exception(e.message))
        } catch (e: Exception) {
            println("e: $e")
            return Result.failure(Exception(e.message))
        }
    }
}