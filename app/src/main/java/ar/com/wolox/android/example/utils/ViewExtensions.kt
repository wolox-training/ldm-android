package ar.com.wolox.android.example.utils

import android.view.View
import android.widget.ProgressBar
import ar.com.wolox.android.example.ui.home.TabsData
import com.google.android.material.tabs.TabLayout

fun ProgressBar.toggleVisibilityAnimation(toggle: Boolean) {
    this.visibility = if (toggle) View.VISIBLE else View.GONE
}

fun TabLayout.enableTabColorChange() {
    addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            tab.setIcon(TabsData.tabArrayIconsON[tab.position])
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            tab.setIcon(TabsData.tabArrayIconsOFF[tab.position])
        }

        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}