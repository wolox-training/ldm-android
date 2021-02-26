package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    private var newsAdapter: NewsAdapter = NewsAdapter(listOf())

    override fun init() {}

    override fun layout() = R.layout.fragment_news

    override fun setListeners() {
        super.setListeners()
        with(binding) {
            swipeRefresh.setOnRefreshListener { // Since the backend was not implemented yet, the animation doesn't last much.
                presenter.updateNews()
                swipeRefresh.isRefreshing = false
            }
        }
    }

    override fun updateNews(news: List<News>) {
        newsAdapter.updateNews(news)
        newsAdapter.notifyDataSetChanged()
    }

    override fun showNews(news: List<News>) {
        newsAdapter = NewsAdapter(news)
        binding.recyclerView.adapter = newsAdapter
    }
}