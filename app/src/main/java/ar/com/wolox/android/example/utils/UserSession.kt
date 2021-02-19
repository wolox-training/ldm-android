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
    var email: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.EMAIL, null].also {
            field = it
        }
        set(username) {
            field = username
            sharedPreferencesManager.store(Extras.UserLogin.EMAIL, username)
        }

    var password: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.PASSWORD, null].also {
            field = it
        }
        set(password) {
            field = password
            sharedPreferencesManager[Extras.UserLogin.PASSWORD, password]
        }

    var accessToken: String? = null
        get() = field ?: sharedPreferencesManager[NetworkHeaders.ACCESS_TOKEN, null].also {
            field = it
        }
        set(token) {
            field = token
            sharedPreferencesManager[NetworkHeaders.ACCESS_TOKEN, token]
        }

    var uid: String? = null
        get() = field ?: sharedPreferencesManager[NetworkHeaders.UID, null].also {
            field = it
        }
        set(uid) {
            field = uid
            sharedPreferencesManager[NetworkHeaders.UID, uid]
        }

    var client: String? = null
        get() = field ?: sharedPreferencesManager[NetworkHeaders.CLIENT, null].also {
            field = it
        }
        set(client) {
            field = client
            sharedPreferencesManager[NetworkHeaders.CLIENT, uid]
        }

    val userIsLogged: Boolean
        get() = email != "" && password != ""
}
