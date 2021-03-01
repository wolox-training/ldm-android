package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.NewData

interface NewsView {
    fun showNews(news: ArrayList<NewData>)

    fun updateNews(news: ArrayList<NewData>)

    fun showNoNewNewsAlert()

    fun showNoNetworkAlert()
}