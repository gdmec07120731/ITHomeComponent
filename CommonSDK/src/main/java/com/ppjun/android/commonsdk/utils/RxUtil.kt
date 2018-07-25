package com.ppjun.android.commonsdk.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxUtil private constructor() {

    init {
        throw IllegalStateException("you can't instantiate me!")
    }

    companion object {

        fun <T> io2main(): ObservableTransformer<T, T> {
            return ObservableTransformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }

        }
    }
}