package ar.com.wolox.android.example.ui.splashcreen

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo

class SplashActivity : WolmoActivity<ActivityBaseBinding>() {
    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, SplashFragment.newInstance())
    }

    companion object {
        fun start(context: Context) = context.jumpTo(SplashActivity::class.java)
    }
}