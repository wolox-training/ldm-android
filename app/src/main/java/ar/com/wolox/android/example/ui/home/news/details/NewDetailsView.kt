package ar.com.wolox.android.example.ui.home.news.details

import ar.com.wolox.android.example.model.New

interface NewDetailsView {
    fun renderNew(new: New)

    fun showNoNetworkAlert()

    fun toggleSpinnerVisibility(toggle: Boolean)

    fun showLikeNewNotification()

    fun showWrongCredentialsAlert()

    fun disableSwipeRefreshLoader()
}