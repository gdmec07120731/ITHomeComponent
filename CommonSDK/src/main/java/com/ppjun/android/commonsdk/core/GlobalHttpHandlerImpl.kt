package com.ppjun.android.commonsdk.core

import com.jess.arms.http.GlobalHttpHandler
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class GlobalHttpHandlerImpl:GlobalHttpHandler {
    override fun onHttpRequestBefore(chain: Interceptor.Chain?, request: Request): Request {

        return request

    }

    override fun onHttpResultResponse(httpResult: String?, chain: Interceptor.Chain?, response: Response): Response {

    return response
    }
}