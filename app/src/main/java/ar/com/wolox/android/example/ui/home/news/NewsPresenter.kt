package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.New
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
    private var news: ArrayList<New> = arrayListOf()

    private var currentPage: Int = 1
    private var totalPages: Int = 1
    private var activeCoroutine: Boolean = false

    private fun fetchNews() = launch {
        if (!activeCoroutine) {
            activeCoroutine = true
            networkRequest(newRepository.getNews(currentPage)) {
                onResponseSuccessful { it ->
                    totalPages = it!!.totalPages
                    news = it.page
                    news.sortByDescending { newDate -> newDate.date }
                    currentPage++
                    view?.showNews(news)
                }
                onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
                onCallFailure { view?.showNoNetworkAlert() }
            }
            activeCoroutine = false
        }
    }

    fun onUpdateNews(updateInvokeMethod: UpdateInvokeMethod) = launch {
        if (!activeCoroutine) {
            activeCoroutine = true
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
                    onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
                    onCallFailure { view?.showNoNetworkAlert() }
                }
            } else {
                view?.showTotalPagesReachedAlert()
            }
            activeCoroutine = false
            view?.disableSwipeRefreshLoader()
        }
    }

    fun sortNews() {
        news.sortByDescending { newDate -> newDate.date }
        view?.updateNews(news)
    }

    fun refreshNews() = launch {
        if (!activeCoroutine) {
            activeCoroutine = true
            currentPage = 1
            networkRequest(newRepository.getNews(currentPage)) {
                onResponseSuccessful { it ->
                    totalPages = it!!.totalPages
                    news = it.page
                    currentPage++
                    view?.updateNews(news)
                }
                onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
                onCallFailure { view?.showNoNetworkAlert() }
            }
            activeCoroutine = false
        }
    }

    fun onUpdateLike(newId: Int) = launch {
        if (!activeCoroutine) {
            activeCoroutine = true
            networkRequest(newRepository.updateLike(newId)) {
                onResponseSuccessful {
                    view?.showLikeNewNotification()
                    news.first {
                        it.id == newId
                    }.run {
                        if (userSession.id in this.likes) {
                            this.likes.remove(userSession.id)
                        } else {
                            this.likes.add(userSession.id!!)
                        }
                    }
                }
                onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
                onCallFailure { view?.showNoNetworkAlert() }
                // The update is done here, since if the connection was refused, or the credentials failed
                // the like button will be un-toggled, and the last saved state of the news will remain.
                view?.updateNews(news)
            }
            activeCoroutine = false
        }
    }

    fun userHasLiked(likesArray: ArrayList<Int>) = userSession.id in likesArray
}