package com.ppjun.android.commonres.dialog

import android.app.Dialog
import android.content.Context
import com.ppjun.android.commonres.R

class ProgressDialog(context: Context) : Dialog(context) {

   init {
       setContentView(R.layout.public_dialog_porgress)
       setCanceledOnTouchOutside(false)
   }
}