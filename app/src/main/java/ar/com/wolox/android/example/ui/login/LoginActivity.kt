package ar.com.wolox.android.example.ui.login

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo
import ar.com.wolox.wolmo.core.util.jumpToClearingTask

class LoginActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, LoginFragment.newInstance())
    }

    companion object {
        fun start(context: Context) = context.jumpTo(LoginActivity::class.java)
        fun startClearingCurrentTask(context: Context) = context.jumpToClearingTask(LoginActivity::class.java)
    }
}
