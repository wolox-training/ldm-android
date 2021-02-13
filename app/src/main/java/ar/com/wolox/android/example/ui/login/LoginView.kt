package ar.com.wolox.android.example.ui.login

interface LoginView {

    fun goToViewPager(favouriteColor: String)

    fun openBrowser(url: String)

    fun checkErrors(Errors: MutableMap<String, MutableList<String>>)

    fun openPhone(woloxPhone: String): Any
}
