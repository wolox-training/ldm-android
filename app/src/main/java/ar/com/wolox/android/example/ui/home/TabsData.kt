package ar.com.wolox.android.example.ui.home

import ar.com.wolox.android.R

class TabsData {
    companion object {
        val tabArrayIconsON: Array<Int> = arrayOf(
                R.drawable.ic_news_list_on,
                R.drawable.ic_profile_on
        )
        val tabArrayIconsOFF: Array<Int> = arrayOf(
                R.drawable.ic_news_list_off,
                R.drawable.ic_profile_off
        )
        val tabArrayText: Array<Int> = arrayOf(
                R.string.news_fragment_title,
                R.string.profile_fragment_title
        )
    }
}