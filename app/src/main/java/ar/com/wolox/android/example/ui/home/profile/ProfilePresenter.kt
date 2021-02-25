package ar.com.wolox.android.example.ui.home.profile

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class ProfilePresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<ProfileView>()