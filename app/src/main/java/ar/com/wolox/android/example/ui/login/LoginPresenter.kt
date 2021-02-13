package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    override fun onViewAttached() {
        if (userSession.userIsLogged) {
            view?.goToViewPager(userSession.email.toString())
        }
    }

    fun onLoginButtonClicked(email: String, password: String) {
        val errorEnum = mutableListOf<ErrorEnum>()
        if (email.isEmpty()) errorEnum.add(ErrorEnum.EMPTY_EMAIL)
        if (password.isEmpty()) errorEnum.add(ErrorEnum.EMPTY_PASSWORD)
        if (email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()) errorEnum.add(ErrorEnum.INVALID_EMAIL)

        if (errorEnum.isEmpty()) {
            userSession.email = email
            userSession.password = password
            view?.goToViewPager(email)
        } else {
            view?.checkErrors(errorEnum)
        }
    }
    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}