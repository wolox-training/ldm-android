package ar.com.wolox.android.example.ui.example

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class ExampleActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.activity_base

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, ExampleFragment.newInstance())
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(layout())
        var sharedPreferences = getSharedPreferences("CREDENTIALS", Context.MODE_PRIVATE)

    }
}
