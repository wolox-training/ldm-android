package ar.com.wolox.android.example.ui.example

interface ExampleView {

    fun goToViewPager(favouriteColor: String)

    fun openBrowser(url: String)

    fun toggleEmptyEmailAlert()

    fun toggleEmptyPasswordAlert()

    fun toggleInvalidEmailAlert()

    fun openPhone(woloxPhone: String): Any
}
