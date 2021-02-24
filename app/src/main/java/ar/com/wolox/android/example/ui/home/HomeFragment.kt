package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentHomeBinding
import ar.com.wolox.android.example.ui.login.LoginActivity
import ar.com.wolox.android.example.ui.viewpager.random.RandomFragment
import ar.com.wolox.android.example.ui.viewpager.request.RequestFragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class HomeFragment : WolmoFragment<FragmentHomeBinding, HomePresenter>(), HomeView {

    @Inject
    internal lateinit var randomFragment: RandomFragment

    @Inject
    internal lateinit var requestFragment: RequestFragment

    override fun init() {
        binding.viewPager.adapter = SimpleFragmentPagerAdapter(childFragmentManager).apply {
            addFragments(
                    randomFragment to "Page 1",
                    requestFragment to "Page 2")
        }
        with(binding) {
            val tab1 = tabLayout.newTab().apply {
                text = "Text1"
            }
            tabLayout.addTab(tabLayout.newTab().setText("Text 1"))
            tabLayout.addTab(tabLayout.newTab().setText("Text 2"))
            tabLayout.setupWithViewPager(viewPager)
//            viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//            tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                override fun onTabSelected(tab: TabLayout.Tab) {
//                    viewPager!!.currentItem = tab.position
//                }
//                override fun onTabUnselected(tab: TabLayout.Tab) {
//                }
//                override fun onTabReselected(tab: TabLayout.Tab) {
//                }
//            })
        }
    }

    override fun layout() = R.layout.fragment_home

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun goToLoginPage() = LoginActivity.start(requireContext())
}