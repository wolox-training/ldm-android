package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.New

interface NewsView {
    fun showNews(news: List<New>)

    fun updateNews(news: List<New>)

    fun showNoNewNewsAlert()

    fun showNoNetworkAlert()
}