package ar.com.wolox.android.example.ui.home.news.details

import ar.com.wolox.android.databinding.FragmentNewDetailBinding
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class NewDetailsFragment : WolmoFragment<FragmentNewDetailBinding, NewDetailsPresenter>(), NewDetailsView {
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun layout(): Int {
        TODO("Not yet implemented")
    }

    override fun requestNewDetails(Id: Int) {
        TODO("Not yet implemented")
    }

    override fun renderNew(new: New) {
        TODO("Not yet implemented")
    }

    override fun showNoNetworkAlert() {
        TODO("Not yet implemented")
    }

    override fun putLikeToTheNew(Id: Int) {
        TODO("Not yet implemented")
    }
}