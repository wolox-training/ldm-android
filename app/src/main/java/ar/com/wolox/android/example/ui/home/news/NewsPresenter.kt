package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<NewsView>() {

    fun fetchNews() {
        view?.showNews(NEWS)
    }

    companion object {
        private val NEWS = listOf<String>(
                "News nº 1",
                "News nº 2",
                "News nº 3",
                "News nº 4",
                "News nº 5",
                "News nº 6",
                "News nº 7"
        )
    }
}