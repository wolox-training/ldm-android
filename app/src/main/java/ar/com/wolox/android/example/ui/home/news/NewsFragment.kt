package ar.com.wolox.android.example.ui.home.news

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewsBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<FragmentNewsBinding, NewsPresenter>(), NewsView {
    override fun init() {
        val a = NewsAdapter(arrayOf("a", "b", "c", "d", "e", "f"))
        a.onBindViewHolder(NewsAdapter.ViewHolder(view!!), 0)
        binding.recyclerView.adapter = a
    }

    override fun layout() = R.layout.fragment_news
}