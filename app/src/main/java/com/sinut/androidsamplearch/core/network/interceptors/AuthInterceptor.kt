package com.sinut.androidsamplearch.core.network.interceptors

import com.sinut.androidsamplearch.core.session.AppSession
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = AppSession.userSession?.token
        val request = chain.request().newBuilder()

        token?.let {
            request.addHeader("userSession", it)
        }

        return chain.proceed(request.build())
    }
}