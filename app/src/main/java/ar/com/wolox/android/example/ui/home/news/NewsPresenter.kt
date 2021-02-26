package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<NewsView>()