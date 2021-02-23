package ar.com.wolox.android.example.ui.splashcreen

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentSplashBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.android.example.utils.fadeInAnimation

class SplashFragment private constructor() : WolmoFragment<FragmentSplashBinding, SplashPresenter>(), SplashView {

    override fun layout() = R.layout.fragment_splash

    override fun init() {
        binding.woloxSplashLogo.fadeInAnimation { presenter.onAnimationFinish() }
    }

    override fun goToHomeScreen() = HomeActivity.start(requireContext())

    override fun goToLogInScreen() = LoginActivity.start(requireContext())

    override fun waitAnimation() {
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}