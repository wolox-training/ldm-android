package ar.com.wolox.android.example.utils

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator

fun View.fadeInAnimation(onAnimationFinish: () -> Unit) {
    val animation: Animation = AlphaAnimation(AnimationUtils.ALPHA_START, AnimationUtils.ALPHA_END).apply {
        duration = AnimationUtils.DURATION
        interpolator = LinearInterpolator()
        setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                onAnimationFinish.invoke()
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
    }
    startAnimation(animation)
}

class AnimationUtils {
    companion object {
        const val DURATION = 2000L
        const val ALPHA_START = 0.0f
        const val ALPHA_END = 1.0f
    }
}