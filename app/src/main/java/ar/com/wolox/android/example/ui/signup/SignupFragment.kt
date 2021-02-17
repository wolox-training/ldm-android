package ar.com.wolox.android.example.ui.signup

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentSignupBinding
import ar.com.wolox.android.example.ui.login.LoginPresenter
import ar.com.wolox.android.example.ui.login.LoginView
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class SignupFragment private constructor() : WolmoFragment<FragmentSignupBinding, SignupPresenter>(), SignupView {
    override fun layout() = R.layout.fragment_login

    override fun init() {
    }
}