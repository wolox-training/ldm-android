package ar.com.wolox.android.example.ui.home.news.details

import android.os.Bundle
import androidx.core.os.bundleOf
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.FragmentNewDetailBinding
import ar.com.wolox.android.example.model.New
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.android.example.utils.Extras.NewDetails.NEW_ID
import ar.com.wolox.android.example.utils.formatTime
import ar.com.wolox.android.example.utils.toggleVisibilityAnimation
import ar.com.wolox.wolmo.core.util.ToastFactory
import javax.inject.Inject

class NewDetailsFragment : WolmoFragment<FragmentNewDetailBinding, NewDetailsPresenter>(), NewDetailsView {

    @Inject
    internal lateinit var toastFactory: ToastFactory

    override fun init() {
        presenter.fetchNewDetail(requireArgument(NEW_ID))
    }

    override fun layout() = R.layout.fragment_new_detail

    override fun handleArguments(arguments: Bundle?) = arguments?.containsKey(NEW_ID)

    override fun setListeners() {
        with(binding) {
            likeButton.setOnClickListener { presenter.updateLikeInNew(requireArgument(NEW_ID)) }
            swipeRefresh.setOnRefreshListener {
                presenter.fetchNewDetail(requireArgument(NEW_ID))
            }
            goBack.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    override fun renderNew(new: New) {
        val (_, commenter, comment, date, avatar, likes, _, _) = new
        with(binding) {
            newTitle.text = commenter
            newBody.text = comment
            timeAgo.text = date.formatTime()
            likeButton.isChecked = presenter.userHasLikedNew()
            // TODO : avatar and likes could be used in other screens
        }
    }

    override fun disableSwipeRefreshLoader() {
        binding.swipeRefresh.isRefreshing = false
    }

    override fun showNoNetworkAlert() = toastFactory.show(R.string.connection_error)

    override fun showLikeNewNotification() = toastFactory.show(R.string.like_new_notification)

    override fun showWrongCredentialsAlert() = toastFactory.show(R.string.wrong_credentials_alert)

    override fun toggleSpinnerVisibility(toggle: Boolean) = binding.newDetailsLoader.toggleVisibilityAnimation(toggle)

    companion object {
        fun newInstance(Id: Int) = NewDetailsFragment().apply {
            arguments = bundleOf(NEW_ID to Id)
        }
    }
}