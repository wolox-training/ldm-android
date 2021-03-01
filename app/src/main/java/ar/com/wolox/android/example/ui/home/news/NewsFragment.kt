package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

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

    override fun showNoNewNewsAlert() = toastFactory.show(R.string.zero_news_alert)

    override fun showNoNetworkAlert() = toastFactory.show(R.string.connection_error)

    override fun updateNews(news: List<New>) {
        newsAdapter.updateNews(news)
        newsAdapter.notifyDataSetChanged()
    }

    override fun showNews(news: List<New>) {
        newsAdapter = NewsAdapter(news)
        binding.recyclerView.adapter = newsAdapter
    }
}