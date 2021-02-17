package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    override fun onViewAttached() {
        if (userSession.userIsLogged) {
            view?.goToHomePage()
        }
    }

    fun onLoginButtonClicked(email: String, password: String) {
        var errorHappened = false
        if (email.isEmpty()) {
            view?.showEmptyEmailError()
            errorHappened = true
        }
        if (password.isEmpty()) {
            view?.showEmptyPasswordError()
            errorHappened = true
        }
        if (email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.showEmailInvalidError()
            errorHappened = true
        }
        if (!errorHappened) {
            userSession.email = email
            userSession.password = password
            view?.goToHomePage()
        }
    }

    fun onSignUpButtonClicked() = view?.goToSignUpPage()

    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}