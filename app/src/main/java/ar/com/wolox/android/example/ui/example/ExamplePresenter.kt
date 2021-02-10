package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class ExamplePresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<ExampleView>() {

    fun onLoginButtonClicked(user: String, color: String) {
        userSession.username = user
        view?.goToViewPager(color)
    }

    fun onUsernameInputChanged(text: String) = view?.toggleLoginButtonEnable(text.isNotBlank())

    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
        private const val WOLOX_PHONE = "08001234567"
    }
}
