package com.ppjun.android.commonsdk.core

import android.content.Context
import android.net.ParseException
import com.google.gson.JsonParseException
import com.jess.arms.utils.ArmsUtils
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener
import org.json.JSONException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ResponseErrorListenerImpl : ResponseErrorListener {
    override fun handleResponseError(context: Context?, t: Throwable?) {
        var msg = "未知道错误"
        when (t) {
            is UnknownHostException -> msg = "网络不可用"
            is SocketTimeoutException -> msg = "请求网络超时"
            is HttpException -> msg = convertStatusCode(t)
            is JsonParseException, is ParseException ,is JSONException->msg="数据解析错误"
        }
        ArmsUtils.snackbarText(msg)
    }

    fun convertStatusCode(httpException: HttpException):String{
        return when (httpException.code()) {
            500 -> "服务器发生错误"
            404 -> "请求地址不存在"
            403 -> "请求被服务器拒绝"
            307 -> "请求被重定向到其他页面"
            else -> httpException.message()
        }


    }


}