package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentHomeBinding
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class HomeFragment : WolmoFragment<FragmentHomeBinding, HomePresenter>(), HomeView {

    @Inject
    internal lateinit var newsFragment: NewsFragment

    @Inject
    internal lateinit var profileFragment: ProfileFragment

    override fun init() {
        with(binding) {
            viewPager.adapter = SimpleFragmentPagerAdapter(childFragmentManager).apply {
                addFragments(
                        newsFragment to "Page 1",
                        profileFragment to "Page 2"
                )
            }
            tabLayout.addTab(tabLayout.newTab().setText("Text 1"))
            tabLayout.addTab(tabLayout.newTab().setText("Text 2"))
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun goToLoginPage() = LoginActivity.start(requireContext())
}