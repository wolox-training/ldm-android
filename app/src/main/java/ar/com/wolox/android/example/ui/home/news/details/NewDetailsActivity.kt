package ar.com.wolox.android.example.ui.home.news.details

import android.content.Context
import android.os.Bundle
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.utils.Extras.NewDetails.NEW_ID
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo

class NewDetailsActivity : WolmoActivity<ActivityBaseBinding>() {
    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, NewDetailsFragment.newInstance(requireArgument(NEW_ID)))
    }

    override fun handleArguments(arguments: Bundle?) = arguments?.containsKey(NEW_ID)

    companion object {
        fun start(context: Context, newId: Int) = context.jumpTo(
                NewDetailsActivity::class.java,
                NEW_ID to newId
        )
    }
}