package com.ppjun.android.commonsdk.core

import android.app.Application
import android.content.Context
import android.support.v4.app.FragmentManager
import com.jess.arms.base.delegate.AppLifecycles
import com.jess.arms.di.module.GlobalConfigModule
import com.jess.arms.http.log.RequestInterceptor
import com.jess.arms.integration.ConfigModule
import com.ppjun.android.commonsdk.BuildConfig
import com.ppjun.android.commonsdk.http.Api.Companion.APP_DOMAIN
import com.ppjun.android.commonsdk.imageEngine.strategy.CommonGlideImageLoaderStrategy

class GlobalConfiguration :ConfigModule {
    override fun injectFragmentLifecycle(context: Context?, lifecycles: MutableList<FragmentManager.FragmentLifecycleCallbacks>?) {

    }

    override fun applyOptions(context: Context?, builder: GlobalConfigModule.Builder) {
        if(!BuildConfig.LOG_DEBUG){
            builder.printHttpLogLevel(RequestInterceptor.Level.NONE)
            builder.baseurl(APP_DOMAIN)
                    .imageLoaderStrategy(CommonGlideImageLoaderStrategy())
                    .globalHttpHandler(GlobalHttpHandlerImpl())


        }

    }

    override fun injectAppLifecycle(context: Context?, lifecycles: MutableList<AppLifecycles>?) {
    }

    override fun injectActivityLifecycle(context: Context?, lifecycles: MutableList<Application.ActivityLifecycleCallbacks>?) {
    }
}