package ar.com.wolox.android.example.ui.login

import android.util.Patterns
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val userSession: UserSession,
    private val userRepository: UserRepository
) : CoroutineBasePresenter<LoginView>() {

    private var loading = false
        set(value) {
            field = value
            view?.toggleSpinnerVisibility(value)
        }

    fun onLoginButtonClicked(email: String, password: String) = launch {
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
            loading = true
            networkRequest(userRepository.authUser(email, password)) {
                onResponseSuccessful {
                    userSession.email = email
                    userSession.password = password
                    userSession.id = it!!.data.id
                    view?.goToHomePage()
                }
                onResponseFailed { _, _ -> view?.showIncorrectCredentialsToast() }
                onCallFailure { view?.showNoConnectionToast() }
            }
            loading = false
        }
    }

    fun onSignUpButtonClicked() = view?.goToSignUpPage()

    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}