package com.ppjun.android.commonsdk.imageEngine.config

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.jess.arms.http.imageloader.ImageConfig

class CommonImageConfigImpl(builder: Builder) : ImageConfig() {

    var cacheStrategy = 0
    var fallback = 0
    var transformation: BitmapTransformation? = null
    var imageViews = arrayOf<ImageView>()
    var isClearMemory = false
    var isClearDiskCache = false
    var placeHolderDrawble: Drawable? = null
    var resizeX = 0
    var resizeY = 0
    var isCropCenter = false
    var isCropCircle = false
    var isFitCenter = false
    var formate: DecodeFormat? = null
    var imageRadius = 0
    var blurValue = 0
    var isCrossFade = false

    init {
        this.url = builder.url
        this.imageView = builder.imageView
        this.placeholder = builder.placeHolder
        this.placeHolderDrawble = builder.placeHolderDrawble
        this.errorPic = builder.errorPic
        this.fallback = builder.fallback
        this.cacheStrategy = builder.cacheStrategy
        this.transformation = builder.transformation
        this.imageViews = builder.imageViews
        this.isClearMemory = builder.isClearMemory
        this.isClearDiskCache = builder.isClearDiskCache
        this.resizeX = builder.resizeX
        this.resizeY = builder.resizeY
        this.isCropCenter = builder.isCropCenter
        this.isCropCircle = builder.isCropCircle
        this.formate = builder.formate
        this.isFitCenter = builder.isFitCenter
        this.isCrossFade = builder.isCrossFade
        this.imageRadius = builder.imageRadius
        this.blurValue = builder.blurValue
    }

    fun isImageRadius(): Boolean {
        return imageRadius > 0
    }

    fun isBlurImage(): Boolean {
        return blurValue > 0
    }

}

fun builder(): Builder {
    return Builder()
}

class Builder {

    var resizeX = 0
    var resizeY = 0
    var url: String? = null
    var imageView: ImageView? = null
    var placeHolder = 0
    var placeHolderDrawble: Drawable? = null
    var errorPic = 0
    var fallback = 0
    var cacheStrategy = 0
    var imageRadius = 0
    var blurValue = 0
    var transformation: BitmapTransformation? = null
    var imageViews = arrayOf<ImageView>()
    var isClearMemory = false
    var isClearDiskCache = false
    var isCropCenter = false
    var isCropCircle = false
    var isCrossFade = false
    var formate: DecodeFormat? = null
    var isFitCenter = false

    fun url(url: String): Builder {
        this.url = url
        return this
    }

    fun placeHolder(placeHolder: Int): Builder {
        this.placeHolder = placeHolder
        return this
    }

    fun errorPic(errorPic: Int): Builder {
        this.errorPic = errorPic
        return this
    }

    fun fallback(fallback: Int): Builder {
        this.fallback = fallback
        return this
    }

    fun imageView(imageView: ImageView): Builder {
        this.imageView = imageView
        return this
    }

    fun cacheStrategy(cacheStrategy: Int): Builder {
        this.cacheStrategy = cacheStrategy
        return this
    }

    fun imageRadius(imageRadius: Int): Builder {
        this.imageRadius = imageRadius
        return this
    }

    fun blurValue(blurValue: Int): Builder {
        this.blurValue = blurValue
        return this
    }

    fun isCrossFade(isCrossFade: Boolean): Builder {
        this.isCrossFade = isCrossFade
        return this
    }

    fun transformation(transformation: BitmapTransformation): Builder {
        this.transformation = transformation
        return this
    }

    fun imageViews(vararg imageViews: ImageView): Builder {
        this.imageViews = imageViews as Array<ImageView>
        return this
    }

    fun isClearMemory(isClearMemory: Boolean): Builder {
        this.isClearMemory = isClearMemory
        return this
    }

    fun isClearDiskCache(isClearDiskCache: Boolean): Builder {
        this.isClearDiskCache = isClearDiskCache
        return this
    }

    fun placeholderDrawble(placeHolderDrawble: Drawable): Builder {
        this.placeHolderDrawble = placeHolderDrawble
        return this
    }

    fun resize(resizeX: Int, resizeY: Int): Builder {
        this.resizeX = resizeX
        this.resizeY = resizeY
        return this
    }

    fun isCropCenter(isCropCenter: Boolean): Builder {
        this.isCropCenter = isCropCenter
        return this
    }

    fun isCropCircle(isCropCircle: Boolean): Builder {
        this.isCropCircle = isCropCircle
        return this
    }

    fun setDecodeFormate(decodeFormate: DecodeFormat): Builder {
        formate = decodeFormate
        return this
    }

    fun isFitCenter(isFitCenter: Boolean): Builder {
        this.isFitCenter = isFitCenter
        return this
    }

    fun build(): CommonImageConfigImpl {
        return CommonImageConfigImpl(this)
    }
}


