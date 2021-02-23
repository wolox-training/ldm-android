package ar.com.wolox.android.example.utils

import ar.com.wolox.android.example.network.NetworkHeaders
import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager

import javax.inject.Inject

@ApplicationScope
class UserSession @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {

    // Really, we don't need to query the username because this instance live as long as the
    // application, but we should add a check in case Android decides to kill the application
    // and return to a state where this isn't initialized.
    var email: String?
        get() = sharedPreferencesManager[Extras.UserLogin.EMAIL, null]
        set(username) {
            sharedPreferencesManager.store(Extras.UserLogin.EMAIL, username)
        }

    var password: String?
        get() = sharedPreferencesManager[Extras.UserLogin.PASSWORD, null]
        set(password) {
            sharedPreferencesManager.store(Extras.UserLogin.PASSWORD, password)
        }


    var accessToken: String?
        get() = sharedPreferencesManager[NetworkHeaders.ACCESS_TOKEN, null]
        set(accessToken) {
            sharedPreferencesManager.store(NetworkHeaders.ACCESS_TOKEN, accessToken)
        }

    var uid: String?
        get() = sharedPreferencesManager[NetworkHeaders.UID, null]
        set(accessToken) {
            sharedPreferencesManager.store(NetworkHeaders.UID, accessToken)
        }

    var client: String?
        get() = sharedPreferencesManager[NetworkHeaders.CLIENT, null]
        set(accessToken) {
            sharedPreferencesManager.store(NetworkHeaders.CLIENT, accessToken)
        }

    val userIsLogged: Boolean
        get() = !accessToken.isNullOrEmpty()
}
