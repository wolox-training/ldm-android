package ar.com.wolox.android.example.ui.home.news.details

import ar.com.wolox.android.example.network.repository.NewRepository
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import javax.inject.Inject

class NewDetailsPresenter @Inject constructor(newsRepository: NewRepository) : CoroutineBasePresenter<NewDetailsView>() {
}