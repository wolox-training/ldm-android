package ar.com.wolox.android.example.ui.home.news.details

import ar.com.wolox.android.example.model.New

interface NewDetailsView {
    fun requestNewDetails(Id : Int)

    fun renderNew(new : New)

    fun showNoNetworkAlert()

    fun putLikeToTheNew(Id : Int)
}