package ar.com.wolox.android.example.ui.home

import androidx.core.content.ContextCompat
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
                        newsFragment to "NewsFragment",
                        profileFragment to "ProfileFragment"
                )
            }
            tabLayout.setupWithViewPager(viewPager)
            tabLayout.getTabAt(0)!!.apply {
                text = getString(R.string.news_fragment_title)
                setIcon(R.drawable.item_tab_news_selector)
            }
            tabLayout.getTabAt(1)!!.apply {
                text = getString(R.string.profile_fragment_title)
                setIcon(R.drawable.item_tab_profile_selector)
            }
            tabLayout.setTabTextColors(
                    ContextCompat.getColor(requireContext(), R.color.greyTab),
                    ContextCompat.getColor(requireContext(), R.color.colorAccent)
            )
        }
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun goToLoginPage() = LoginActivity.start(requireContext())
}