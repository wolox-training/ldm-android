package ar.com.wolox.android.example.ui.login

interface LoginView {

    fun goToViewPager(favouriteColor: String)

    fun openBrowser(url: String)

    fun checkErrors(Errors: MutableList<ErrorEnum>)

    fun openPhone(woloxPhone: String): Any
}
