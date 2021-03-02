package ar.com.wolox.android.example.ui.home.news

import android.util.Log
import ar.com.wolox.android.example.model.NewData
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.ArrayList

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
    private var totalPages: Int = 1

    private fun fetchNews() = launch {
        networkRequest(newRepository.getNews(currentPage)) {
            onResponseSuccessful { it ->
                totalPages = it!!.totalPages
                news = it.page
                news.sortByDescending { newDate -> newDate.date }
                currentPage++
            }
            onResponseFailed { e, m -> Log.i("NewsRequest", "Request failed : $e - $m") } // TODO Maybe of failed credentials, send user to login.
            onCallFailure { view?.showNoNetworkAlert() }
        }
        view?.showNews(news)
    }

    fun updateNews(updateInvokeMethod: UpdateInvokeMethod) = launch {
        if (currentPage <= totalPages) {
            networkRequest(newRepository.getNews(currentPage)) {
                onResponseSuccessful {
                    totalPages = it!!.totalPages
                    when (updateInvokeMethod) {
                        UpdateInvokeMethod.SCROLL -> news.addAll(it.page)
                        else -> news.addAll(0, it.page)
                    }
                    currentPage++
                    if (it.page.isNotEmpty()) view?.updateNews(news) else view?.showNoNewNewsAlert()
                }
                onResponseFailed { e, m -> Log.i("NewsRequest", "Request failed : $e - $m") }
                onCallFailure { view?.showNoNetworkAlert() }
            }
        } else {
            view?.showTotalPagesReachedAlert()
        }
    }
}