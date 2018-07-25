package com.ppjun.android.commonsdk.utils

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class Utils private constructor(){

    init {
        throw IllegalStateException("you can't instantiate me!")
    }


    companion object {
        /**
         * 使用 {@link ARouter} 根据 {@code path} 跳转到对应的页面, 这个方法因为没有使用 {@link Activity}跳转
         * 所以 {@link ARouter} 会自动给 {@link android.content.Intent} 加上 Intent.FLAG_ACTIVITY_NEW_TASK
         * 如果不想自动加上这个 Flag 请使用 {@link ARouter#getInstance()#navigation(Context, String)} 并传入 {@link Activity}
         *
         * @param path {@code path}
         */
        fun navigation(path:String){
            ARouter.getInstance().build(path).navigation()

        }
        /**
         * 使用 {@link ARouter} 根据 {@code path} 跳转到对应的页面, 如果参数 {@code context} 传入的不是 {@link Activity}
         * {@link ARouter} 就会自动给 {@link android.content.Intent} 加上 Intent.FLAG_ACTIVITY_NEW_TASK
         * 如果不想自动加上这个 Flag 请使用 {@link Activity} 作为 {@code context} 传入
         *
         * @param context
         * @param path
         */
        fun navigation(context: Context, path:String){
            ARouter.getInstance().build(path).navigation(context)

        }
    }
}