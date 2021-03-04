package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.New
import kotlinx.coroutines.Job

interface NewsView {
    fun showNews(news: ArrayList<New>)

    fun updateNews(news: ArrayList<New>)

    fun toggleLikeButton(likesArray: ArrayList<Int>): Boolean

    fun disableSwipeRefreshLoader()

    fun onUpdateLike(newId: Int)

    fun goToNewDetail(id: Int)

    fun showNoNewNewsAlert()

    fun showNoNetworkAlert()

    fun showTotalPagesReachedAlert()

    fun showWrongCredentialsAlert()

    fun showLikeNewNotification()
}