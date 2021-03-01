package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<NewsView>() {

    override fun onViewAttached() {
        super.onViewAttached()
        fetchNews()
    }

    // The presenter stores the news retrieved from backend.
    private var news: ArrayList<New> = arrayListOf()

    private fun fetchNews() { // In the next card, this method will hit the backend to retrieve the first list of news.
        news = arrayListOf(
                NEWS[0],
                NEWS[1],
                NEWS[2],
                NEWS[3],
                NEWS[4]
        )
        view?.showNews(news)
    }

    fun updateNews() { // In the next card, this method will hit the backend to retrieve more news, and put it them into the current list.
        val newsFetched = arrayListOf<New>()
        news.addAll(newsFetched)
        // Sort news by date
        val anyNews = newsFetched.isNotEmpty()
        if (anyNews) view?.updateNews(news) else view?.showNoNewNewsAlert()
    }

    companion object {
        private const val LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        private val NEWS = arrayListOf(
                New("News nº 1", LIPSUM, "", "15m"),
                New("News nº 2", LIPSUM, "", "15m"),
                New("News nº 3", LIPSUM, "", "15m"),
                New("News nº 4", LIPSUM, "", "15m"),
                New("News nº 5", LIPSUM, "", "15m"),
                New("News nº 6", LIPSUM, "", "15m"),
                New("News nº 7", LIPSUM, "", "15m"),
                New("News nº 8", LIPSUM, "", "15m"),
                New("News nº 9", LIPSUM, "", "15m"),
                New("News nº 10", LIPSUM, "", "15m"),
                New("News nº 11", LIPSUM, "", "15m")
        )
    }
}