package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentHomeBinding
import ar.com.wolox.android.example.ui.home.news.NewsFragment
import ar.com.wolox.android.example.ui.home.profile.ProfileFragment
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.android.example.utils.enableTabColorChange
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
            tabLayout.setupWithViewPager(viewPager)
            for (i in 0 until tabLayout.tabCount) {
                tabLayout.getTabAt(i)!!.apply {
                    text = getString(TabsData.tabArrayText[i])
                    setIcon(if (i == 0) TabsData.tabArrayIconsON[i] else TabsData.tabArrayIconsOFF[i])
                }
            }
            tabLayout.enableTabColorChange()
/*
* The same code is in "ViewExtensions.kt", left here because I don't know if its better to have it there.
tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    tab.setIcon(TabsData.tabArrayIconsON[tab.position])
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    tab.setIcon(TabsData.tabArrayIconsOFF[tab.position])
                }

                override fun onTabReselected(tab: TabLayout.Tab) {}
            })*/
        }
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun goToLoginPage() = LoginActivity.start(requireContext())
}