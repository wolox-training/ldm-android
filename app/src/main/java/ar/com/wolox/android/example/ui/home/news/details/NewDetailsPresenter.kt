package ar.com.wolox.android.example.ui.home.news.details

import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewDetailsPresenter @Inject constructor(private val newsRepository: NewRepository, private val userSession: UserSession) : CoroutineBasePresenter<NewDetailsView>() {
    private lateinit var new: New

    private var loading = false
        set(value) {
            field = value
            view?.toggleSpinnerVisibility(value)
        }

    fun fetchNewDetail(id: Int) = launch {
        loading = true
        networkRequest(newsRepository.getNew(id)) {
            onResponseSuccessful { fetchedNew ->
                new = fetchedNew!!
                view?.renderNew(new)
            }
            onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
            onCallFailure { view?.showNoNetworkAlert() }
        }
        loading = false
        view?.disableSwipeRefreshLoader()
    }

    fun updateLikeInNew(newId: Int) = launch {
        networkRequest(newsRepository.updateLike(newId)) {
            onResponseSuccessful { view?.showLikeNewNotification() }
            onResponseFailed { _, _ -> view?.showWrongCredentialsAlert() }
            onCallFailure { view?.showNoNetworkAlert() }
        }
    }

    fun userHasLikedNew(): Boolean {
        return userSession.id in new.likes
    }
}