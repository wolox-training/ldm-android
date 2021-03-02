package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.utils.infiniteScroll
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

    private var newsAdapter: NewsAdapter = NewsAdapter(arrayListOf())

    override fun init() {}

    override fun layout() = R.layout.fragment_news

    override fun setListeners() {
        super.setListeners()
        with(binding) {
            swipeRefresh.setOnRefreshListener {
                presenter.updateNews(UpdateInvokeMethod.PULL_DOWN)
                swipeRefresh.isRefreshing = false
            }
            recyclerView.infiniteScroll {
                presenter.updateNews(UpdateInvokeMethod.SCROLL)
            }
        }
    }

    override fun showNoNewNewsAlert() = toastFactory.show(R.string.zero_news_alert)

    override fun showNoNetworkAlert() = toastFactory.show(R.string.connection_error)

    override fun showTotalPagesReachedAlert() = toastFactory.show(R.string.total_pages_reached_alert)

    override fun showWrongCredentialsAlert() = toastFactory.show(R.string.wrong_credentials_alert)

    override fun updateNews(news: ArrayList<New>) {
        newsAdapter.updateNews(news)
        newsAdapter.notifyDataSetChanged()
    }

    override fun showNews(news: ArrayList<New>) {
        newsAdapter = NewsAdapter(news)
        binding.recyclerView.adapter = newsAdapter
    }
}