package ar.com.wolox.android.example.ui.home

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo
import ar.com.wolox.wolmo.core.util.jumpToClearingTask

class HomeActivity : WolmoActivity<ActivityBaseBinding>() {
    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, HomeFragment.newInstance())
    }

    companion object {
        fun start(context: Context) = context.jumpTo(
                HomeActivity::class.java
        )
        fun startClearingCurrentTask(context: Context) = context.jumpToClearingTask(HomeActivity::class.java)
    }
}
