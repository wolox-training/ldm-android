package ar.com.wolox.android.example.ui.login

import android.view.View
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentLoginBinding
import ar.com.wolox.android.example.ui.home.HomeActivity
import ar.com.wolox.android.example.ui.signup.SignupActivity
import ar.com.wolox.android.example.utils.toggleVisibilityAnimation
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import ar.com.wolox.wolmo.core.util.openBrowser
import ar.com.wolox.wolmo.core.util.openDial
import javax.inject.Inject

class LoginFragment private constructor() : WolmoFragment<FragmentLoginBinding, LoginPresenter>(), LoginView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

    override fun layout() = R.layout.fragment_login

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            termsAndConditions.setOnClickListener { presenter.onWoloxTermsAndConditionsClicked() }
            loginButton.setOnClickListener {
                presenter.onLoginButtonClicked(email.text.toString().trim(), password.text.toString().trim())
            }
            signUpButton.setOnClickListener { presenter.onSignUpButtonClicked() }
        }
    }

    override fun goToSignUpPage() = SignupActivity.start(requireContext())

    override fun toggleSpinnerVisibility(toggle: Boolean) = binding.progressBar.toggleVisibilityAnimation(toggle)


    override fun showIncorrectCredentialsToast() {
        toastFactory.show("Error de credenciales")
    }

    override fun showNoConnectionToast() {
        TODO("Not yet implemented")
    }

    override fun goToHomePage() = HomeActivity.start(requireContext())

    override fun openBrowser(url: String) = requireContext().openBrowser(url)

    override fun openPhone(woloxPhone: String) = requireContext().openDial(woloxPhone)

    override fun showEmptyPasswordError() {
        binding.password.error = getString(R.string.login_alert_input)
    }

    override fun showEmptyEmailError() {
        binding.email.error = getString(R.string.login_alert_input)
    }

    override fun showEmailInvalidError() {
        binding.email.error = getString(R.string.login_alert_bad_email)
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}