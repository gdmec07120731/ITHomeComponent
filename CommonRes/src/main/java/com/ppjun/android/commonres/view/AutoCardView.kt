package com.ppjun.android.commonres.view

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet
import com.zhy.autolayout.AutoFrameLayout
import com.zhy.autolayout.utils.AutoLayoutHelper

class AutoCardView(context: Context, attrs: AttributeSet?) : CardView(context, attrs) {

    val mHelper=AutoLayoutHelper(this)


    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return AutoFrameLayout.LayoutParams(context,attrs)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if(!isInEditMode){
            mHelper.adjustChildren()
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}