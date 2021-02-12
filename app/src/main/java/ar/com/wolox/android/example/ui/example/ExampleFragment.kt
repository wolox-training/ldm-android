package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentExampleBinding
import ar.com.wolox.android.example.ui.viewpager.ViewPagerActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser
import ar.com.wolox.wolmo.core.util.openDial

class ExampleFragment private constructor() : WolmoFragment<FragmentExampleBinding, ExamplePresenter>(), ExampleView {

    override fun layout() = R.layout.fragment_example

    override fun init() {
        presenter.userWasLogged()
    }

    override fun setListeners() {
        with(binding) {
            termsAndConditions.setOnClickListener { presenter.onWoloxTermsAndConditionsClicked() }
            loginButton.setOnClickListener {
                presenter.onLoginButtonClicked(email.text.toString(), password.text.toString())
            }
        }
    }

    override fun checkErrors(Errors: MutableMap<String, MutableList<String>>) {
        Errors.forEach { (s, mutableList) ->
            if (mutableList.isNotEmpty()) {
                if (s == "email") binding.email.error = mutableList.joinToString { "$it \n" }
                if (s == "password") binding.password.error = mutableList.joinToString { "$it \n" }
            }
        }
    }

    override fun goToViewPager(favouriteColor: String) = ViewPagerActivity.start(requireContext(), favouriteColor)

    override fun openBrowser(url: String) = requireContext().openBrowser(url)

    override fun openPhone(woloxPhone: String) = requireContext().openDial(woloxPhone)

    companion object {
        fun newInstance() = ExampleFragment()
    }
}
