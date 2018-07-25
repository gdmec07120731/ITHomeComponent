package com.ppjun.android.commonservice.gank.service

import com.alibaba.android.arouter.facade.template.IProvider
import com.ppjun.android.commonservice.gank.bean.GankInfo

interface GankInfoService : IProvider {
    fun getInfo(): GankInfo
}