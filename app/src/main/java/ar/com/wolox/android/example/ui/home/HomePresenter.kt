package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class HomePresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<HomeView>() {
    override fun onViewAttached() {
        if (!userSession.userIsLogged) {
            view?.goToLoginPage()
        }
    }
}