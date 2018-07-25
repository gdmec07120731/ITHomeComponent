package com.ppjun.android.commonsdk.core

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toolbar
import com.jess.arms.utils.ArmsUtils
import org.w3c.dom.Text


class ActivityLifecycleCallbacksImpl : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity?) {

    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity) {

        if (activity.intent.getBooleanExtra("isInitToolbar", false)) {
            activity.intent.putExtra("isInitToolbar", true)
            val toolbar=com.jess.arms.utils.ArmsUtils.findViewByName<android.support.v7.widget.Toolbar>(activity.applicationContext, activity, "public_toolbar")
            if (toolbar!= null) {
                if (activity is AppCompatActivity) {
                    activity.setSupportActionBar(toolbar)
                    requireNotNull(activity.supportActionBar).setDisplayShowTitleEnabled(false)

                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val widgetToolbar=com.jess.arms.utils.ArmsUtils.findViewByName<Toolbar>(activity.applicationContext, activity, "public_toolbar")
                        activity.setActionBar(widgetToolbar)
                        activity.actionBar.setDisplayShowTitleEnabled(false)
                    }
                }
            }
            val toolbarTv=ArmsUtils.findViewByName<TextView>(activity.applicationContext, activity, "public_toolbar_title")
            toolbarTv?.text = activity.title

            val back = ArmsUtils.findViewByName<TextView>(activity.applicationContext, activity, "public_toolbar_back")
            back?.setOnClickListener {
                activity.onBackPressed()
            }
        }

    }

    override fun onActivityDestroyed(activity: Activity) {

        activity.intent.removeExtra("isInitToolbar")
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }


}