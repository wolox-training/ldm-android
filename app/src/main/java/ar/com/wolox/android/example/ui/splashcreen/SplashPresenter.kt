package ar.com.wolox.android.example.ui.splashcreen

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<SplashView>() {
    fun onAnimationFinish() {
        if (userSession.userIsLogged) view?.goToHomeScreen() else view?.goToLogInScreen()
    }
}