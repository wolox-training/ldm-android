package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.ui.home.news.details.NewDetailsActivity
import ar.com.wolox.android.example.utils.infiniteScroll
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

    private var newsAdapter: NewsAdapter = NewsAdapter(arrayListOf(), this)

    override fun init() {}

    override fun layout() = R.layout.fragment_news

    override fun onResume() {
        super.onResume()
        if (newsAdapter.itemCount != 0) presenter.refreshNews()
    }

    override fun setListeners() {
        super.setListeners()
        with(binding) {
            swipeRefresh.setOnRefreshListener {
                presenter.onUpdateNews(UpdateInvokeMethod.PULL_DOWN)
            }
            recyclerView.infiniteScroll {
                presenter.onUpdateNews(UpdateInvokeMethod.SCROLL)
            }
        }
    }

    override fun onUpdateLike(newId: Int) {
        presenter.onUpdateLike(newId)
    }

    override fun goToNewDetail(id: Int) = NewDetailsActivity.start(requireContext(), id)

    override fun disableSwipeRefreshLoader() {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun toggleLikeButton(likesArray: ArrayList<Int>) = presenter.userHasLiked(likesArray)

    override fun showNoNewNewsAlert() = toastFactory.show(R.string.zero_news_alert)

    override fun showNoNetworkAlert() = toastFactory.show(R.string.connection_error)

    override fun showTotalPagesReachedAlert() = toastFactory.show(R.string.total_pages_reached_alert)

    override fun showWrongCredentialsAlert() = toastFactory.show(R.string.wrong_credentials_alert)

    override fun showLikeNewNotification() = toastFactory.show(R.string.like_new_notification)

    override fun updateNews(news: ArrayList<New>) {
        newsAdapter.updateNews(news)
        newsAdapter.notifyDataSetChanged()
    }

    override fun showNews(news: ArrayList<New>) {
        newsAdapter = NewsAdapter(news, this)
        binding.recyclerView.adapter = newsAdapter
    }
}