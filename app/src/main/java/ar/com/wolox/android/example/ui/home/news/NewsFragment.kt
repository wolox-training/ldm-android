package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    override fun init() {
        presenter.fetchNews()
    }

    override fun layout() = R.layout.fragment_news

    override fun showNews(news: List<String>) {
        val newsAdapter = NewsAdapter(news)
        binding.recyclerView.adapter = newsAdapter
    }
}