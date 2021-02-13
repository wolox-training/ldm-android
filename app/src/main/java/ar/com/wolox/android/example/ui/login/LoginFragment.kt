package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser
import ar.com.wolox.wolmo.core.util.openDial

class LoginFragment private constructor() : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.fragment_login

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            termsAndConditions.setOnClickListener { presenter.onWoloxTermsAndConditionsClicked() }
            loginButton.setOnClickListener {
                presenter.onLoginButtonClicked(email.text.toString().trim(), password.text.toString().trim())
            }
        }
    }

    override fun checkErrors(Errors: MutableList<ErrorEnum>) {
        Errors.forEach {
            when (it) {
                ErrorEnum.EMPTY_PASSWORD -> binding.password.error = getString(R.string.login_alert_input)
                ErrorEnum.INVALID_EMAIL -> binding.email.error = getString(R.string.login_alert_bad_email)
                ErrorEnum.EMPTY_EMAIL -> binding.email.error = getString(R.string.login_alert_input)
            }
        }
    }

    override fun goToViewPager(favouriteColor: String) = ViewPagerActivity.start(requireContext(), favouriteColor)

    override fun openBrowser(url: String) = requireContext().openBrowser(url)

    override fun openPhone(woloxPhone: String) = requireContext().openDial(woloxPhone)

    companion object {
        fun newInstance() = LoginFragment()
    }
}
