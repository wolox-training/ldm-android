package ar.com.wolox.android.example.utils

import android.app.Activity
import android.content.SharedPreferences
import androidx.fragment.app.Fragment

/**
 * Util class to store keys to use with [SharedPreferences] or as argument between
 * [Fragment] or [Activity].
 */
object Extras {

    object UserLogin {
        const val EMAIL = "username"
        const val PASSWORD = "password"
        const val ID = "id"
    }

    object ViewPager {
        const val FAVOURITE_COLOR_KEY = "FAVOURITE_COLOR_KEY"
    }

    object NewDetails {
        const val NEW_ID = "ID"
    }
}
