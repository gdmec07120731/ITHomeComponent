package com.ppjun.android.commonsdk.imageEngine.strategy

import android.content.Context
import android.text.TextUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jess.arms.http.imageloader.BaseImageLoaderStrategy
import com.jess.arms.http.imageloader.glide.BlurTransformation
import com.jess.arms.http.imageloader.glide.GlideAppliesOptions
import com.jess.arms.http.imageloader.glide.GlideArms
import com.jess.arms.http.imageloader.glide.GlideRequests
import com.jess.arms.utils.Preconditions
import com.ppjun.android.commonsdk.imageEngine.config.CommonImageConfigImpl
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

class CommonGlideImageLoaderStrategy : BaseImageLoaderStrategy<CommonImageConfigImpl>, GlideAppliesOptions {
    override fun clear(ctx: Context, config: CommonImageConfigImpl) {
        Preconditions.checkNotNull(ctx, "Context is required")
        Preconditions.checkNotNull(config, "ImageConfigImpl is required")
        if (config?.imageViews != null && config.imageViews.isNotEmpty()) {
            for (imageView in config.imageViews) {
                GlideArms.get(ctx)
                        .requestManagerRetriever.get(ctx)
                        .clear(imageView)
            }
        }


        if (config.isClearDiskCache) {
            Observable.just(0)
                    .observeOn(Schedulers.io())
                    .subscribe {
                        Glide.get(ctx)
                                .clearDiskCache()
                    }
        }

        if (config.isClearMemory) {
            Observable.just(0)
                    .observeOn(Schedulers.io())
                    .subscribe {
                        Glide.get(ctx)
                                .clearMemory()
                    }
        }

    }

    override fun loadImage(ctx: Context, config: CommonImageConfigImpl) {
        Preconditions.checkNotNull(ctx, "Context is required")
        Preconditions.checkNotNull(config, "ImageConfigImpl is required")
        if (TextUtils.isEmpty(config.url)) throw NullPointerException("url is required")
        Preconditions.checkNotNull(config.imageView, "ImageView is required")

        val requests = GlideArms.with(ctx)
        val glideRequest = requests.load(config.url)
        when (config.cacheStrategy) {
            0 -> glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL)
            1 -> glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE)
            2 -> glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            3 -> glideRequest.diskCacheStrategy(DiskCacheStrategy.DATA)
            4 -> glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            else -> glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL)
        }
        if (config.isCrossFade) {
            glideRequest.transition(DrawableTransitionOptions.withCrossFade())
        }

        if (config.isImageRadius()) {
            glideRequest.transform(RoundedCorners(config.imageRadius))
        }

        if (config.isBlurImage()) {
            glideRequest.transform(BlurTransformation(config.blurValue))
        }
        config.transformation?.let {
            glideRequest.transform(it)
        }
        config.placeHolderDrawble?.let {
            glideRequest.placeholder(it)
        }
        config.formate?.let {
            glideRequest.format(it)
        }
        if (config.placeholder != 0) {
            glideRequest.placeholder(config.placeholder)
        }
        if (config.errorPic != 0) {
            glideRequest.error(config.errorPic)
        }
        if (config.fallback != 0) {
            glideRequest.fallback(config.fallback)
        }
        if (config.resizeX != 0 && config.resizeY != 0) {
            glideRequest.override(config.resizeX, config.resizeY)
        }
        if (config.isCropCenter) {
            glideRequest.centerCrop()
        }
        if (config.isCropCircle) {
            glideRequest.circleCrop()
        }
        if (config.isFitCenter) {
            glideRequest.fitCenter()
        }
        glideRequest.into(config.imageView)
    }

    override fun applyGlideOptions(context: Context?, builder: GlideBuilder?) {
    }
}