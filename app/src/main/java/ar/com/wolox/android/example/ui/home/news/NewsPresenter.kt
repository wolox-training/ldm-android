package ar.com.wolox.android.example.ui.home.news

import android.util.Log
import ar.com.wolox.android.example.model.NewData
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsPresenter @Inject constructor(
    private val userSession: UserSession,
    private val newRepository: NewRepository
) : CoroutineBasePresenter<NewsView>() {

    override fun onViewAttached() {
        super.onViewAttached()
        fetchNews()
    }

    // The presenter stores the news retrieved from backend.
    private var news: ArrayList<NewData> = arrayListOf()

    private var currentPage: Int = 1

    private fun fetchNews() = launch { // In the next card, this method will hit the backend to retrieve the first list of news.
        networkRequest(newRepository.getNews(currentPage)) {
            onResponseSuccessful {
                news = it!!.page
                view?.showNews(news)
                currentPage++
            }
            onResponseFailed { e, m -> Log.i("NewsRequest", "Request failed : $e - $m") }
            onCallFailure { e -> Log.i("NewsRequest", "Request failed : $e") }
        }
    }

    fun updateNews() = launch { // In the next card, this method will hit the backend to retrieve more news, and put it them into the current list.
        networkRequest(newRepository.getNews(currentPage)) {
            onResponseSuccessful {
                currentPage++
                news.addAll(it!!.page)
                // TODO : Sort by new
                if (it.page.isNotEmpty()) view?.updateNews(news) else view?.showNoNewNewsAlert()
            }
            onResponseFailed { e, m -> Log.i("NewsRequest", "Request failed : $e - $m") }
            onCallFailure { e -> Log.i("NewsRequest", "Request failed : $e") }
        }
    }
}