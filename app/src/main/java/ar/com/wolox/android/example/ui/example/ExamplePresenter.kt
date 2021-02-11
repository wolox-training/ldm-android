package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class ExamplePresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<ExampleView>() {

    fun onLoginButtonClicked(email: String, password: String) {
        when {
            email.trim() == "" -> view?.toggleEmptyEmailAlert()
            password.trim() == "" -> view?.toggleEmptyPasswordAlert()
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches() -> view?.toggleInvalidEmailAlert()
            else -> {
                userSession.username = email
                view?.goToViewPager(email)
            }
        }
    }
    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    // fun onUsernameInputChanged(text: String): Nothing = TODO("implementar")

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
        private const val WOLOX_PHONE = "08001234567"
    }
}