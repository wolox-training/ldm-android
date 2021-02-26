package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.example.model.News

interface NewsView {
    fun showNews(news: List<News>)

    fun updateNews(news: List<News>)
}