package ar.com.wolox.android.example.ui.login

interface LoginView {

    fun goToHomePage()

    fun openBrowser(url: String)

    fun openPhone(woloxPhone: String): Any

    fun showEmptyPasswordError()

    fun showEmptyEmailError()

    fun showEmailInvalidError()

    fun goToSignUpPage()
}