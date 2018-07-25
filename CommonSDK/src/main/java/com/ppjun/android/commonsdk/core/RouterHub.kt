package com.ppjun.android.commonsdk.core

interface RouterHub {
    companion object {
        val APP = "/app"
        val GANK = "/gank"
        val SERVICE = "/service"
        val APP_SPLASHACTIVITY = "$APP/SplashActivity"
        val APP_MAINACTIVITY = "$APP/MainActivity"

        /**
         * 干货集中营分组
         */
        val GANK_SERVICE_GANKINFOSERVICE = "$GANK$SERVICE/GankInfoService"

        val GANK_HOMEACTIVITY = "$GANK/HomeActivity"
    }


}