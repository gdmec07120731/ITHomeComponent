package com.ppjun.android.commonres.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.ppjun.android.commonres.R

class Anim{
    companion object {

        fun comeOut(activity: Activity){
            activity.overridePendingTransition(R.anim.public_translate_left_to_center, R.anim.public_translate_center_to_right )
        }

        fun comeIn(activity: Activity){

            activity.overridePendingTransition(R.anim.public_translate_right_to_center, R.anim.public_translate_center_to_left )
        }


        fun cleanAnim(animView: ImageView?){
            animView?.apply{
                setImageResource(0)
                clearAnimation()
                visibility= View.GONE
            }
        }
    }
}