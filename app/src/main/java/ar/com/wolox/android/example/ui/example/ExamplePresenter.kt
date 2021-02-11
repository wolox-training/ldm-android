package ar.com.wolox.android.example.ui.example

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

fun flattenSize(m: MutableMap<String, MutableList<String>>): Int {
    var acc = 0
    m.forEach { (s, mutableList) -> acc += mutableList.size }
    return acc
}

class ExamplePresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<ExampleView>() {

    fun onLoginButtonClicked(email: String, password: String) {
        var ErrorList: MutableMap<String, MutableList<String>> = mutableMapOf()

        //TODO: How to avoid these lines ? I mean, how to create ErrorList[...] while inserting element in its list
        ErrorList["email"] = mutableListOf()
        ErrorList["password"] = mutableListOf()

        // TODO: How can I make this lines "more" general ?
        if (email.trim() == EMPTY_STRING) ErrorList["email"]?.add(ERROR_INPUT)
        if (password.trim() == EMPTY_STRING) ErrorList["password"]?.add(ERROR_INPUT)
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) ErrorList["email"]?.add(ERROR_BAD_EMAIL)

        if (flattenSize(ErrorList) == 0) {
            println("ENTRE")
            userSession.email = email
            userSession.password = password
            view?.goToViewPager(email)
        } else {
            view?.checkErrors(ErrorList)
        }
    }
    fun onWoloxTermsAndConditionsClicked() = view?.openBrowser(WOLOX_URL)

    fun userWasLogged() {
        if (userSession.email != "" && userSession.password != "") {
            view?.goToViewPager(userSession.email.toString())
        }
    }

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
        private const val WOLOX_PHONE = "08001234567"
        private const val EMPTY_STRING = ""
        private const val ERROR_INPUT = "You must fill all the fields."
        private const val ERROR_BAD_EMAIL = "Invalid email format."
    }
}