package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<NewsView>() {

    override fun onViewAttached() {
        super.onViewAttached()
        fetchNews()
    }

    private fun fetchNews() { // In the next card, this method will hit the backend to retrieve the first list of news.
        view?.showNews(NEWS.subList(0, 5))
    }

    fun updateNews() { // In the next card, this method will hit the backend to retrieve more news, and put it them into the current list.
        view?.updateNews(NEWS.subList(5, 7))
    }

    companion object {
        private const val LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        private val NEWS = listOf(
                News("News nº 1", LIPSUM, "", "15m"),
                News("News nº 2", LIPSUM, "", "15m"),
                News("News nº 3", LIPSUM, "", "15m"),
                News("News nº 4", LIPSUM, "", "15m"),
                News("News nº 5", LIPSUM, "", "15m"),
                News("News nº 6", LIPSUM, "", "15m"),
                News("News nº 7", LIPSUM, "", "15m"),
                News("News nº 8", LIPSUM, "", "15m"),
                News("News nº 9", LIPSUM, "", "15m"),
                News("News nº 10", LIPSUM, "", "15m"),
                News("News nº 11", LIPSUM, "", "15m")
        )
    }
}