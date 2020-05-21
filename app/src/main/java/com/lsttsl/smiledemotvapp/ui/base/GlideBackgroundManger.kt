package com.lsttsl.smiledemotvapp.ui.base

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import androidx.leanback.app.BackgroundManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.GlideDrawable
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import java.lang.ref.WeakReference
import java.util.*


class GlideBackgroundManager {

    private val TAG = GlideBackgroundManager::class.java.simpleName
    private val BACKGROUND_UPDATE_DELAY = 200

    private var mActivityWeakReference: WeakReference<Activity?>? = null
    private var mBackgroundManager: BackgroundManager? = null
    private val mHandler = Handler(Looper.getMainLooper())
    private var mBackgroundURI: String? = null
    private var mBackgroundTimer: Timer? = null

    var instance: GlideBackgroundManager? = null

    /**
     * @param activity
     * The activity to which this WindowManager is attached
     */
    constructor(activity: Activity) {
        mActivityWeakReference = WeakReference(activity)
        mBackgroundManager = BackgroundManager.getInstance(activity)
        mBackgroundManager!!.attach(activity.window)
    }

    private val mGlideDrawableSimpleTarget: SimpleTarget<GlideDrawable> =
        object : SimpleTarget<GlideDrawable>() {
            override fun onResourceReady(
                resource: GlideDrawable,
                glideAnimation: GlideAnimation<in GlideDrawable>
            ) {
                setBackground(resource)
            }
        }

    fun loadImage(imageUrl: String?) {
        mBackgroundURI = imageUrl
        startBackgroundTimer()
    }

    fun setBackground(drawable: Drawable?) {
        if (mBackgroundManager != null) {
            if (!mBackgroundManager!!.isAttached) {
                mBackgroundManager!!.attach(mActivityWeakReference!!.get()!!.window)
            }
            mBackgroundManager!!.drawable = drawable
        }
    }

    inner class UpdateBackgroundTask : TimerTask() {
        override fun run() {
            mHandler.post(Runnable {
                if (mBackgroundURI != null) {
                    updateBackground()
                }
            })
        }
    }

    /**
     * Cancels an ongoing background change
     */
    fun cancelBackgroundChange() {
        mBackgroundURI = null
        cancelTimer()
    }

    /**
     * Stops the timer
     */
    private fun cancelTimer() {
        if (mBackgroundTimer != null) {
            mBackgroundTimer!!.cancel()
        }
    }

    /**
     * Starts the background change timer
     */
    private fun startBackgroundTimer() {
        cancelTimer()
        mBackgroundTimer = Timer()
        /* set delay time to reduce too much background image loading process */mBackgroundTimer!!.schedule(
            UpdateBackgroundTask(),
            BACKGROUND_UPDATE_DELAY.toLong()
        )
    }

    /**
     * Updates the background with the last known URI
     */
    fun updateBackground() {
        if (mActivityWeakReference!!.get() != null) {
            Glide.with(mActivityWeakReference!!.get())
                .load(mBackgroundURI)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mGlideDrawableSimpleTarget)
        }
    }

}










































