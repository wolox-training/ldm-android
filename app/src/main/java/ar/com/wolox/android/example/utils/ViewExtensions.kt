package ar.com.wolox.android.example.utils

import android.view.View
import android.widget.ProgressBar

fun ProgressBar.toggleVisibilityAnimation(toggle: Boolean) {
    this.visibility = if (toggle) View.VISIBLE else View.GONE
}
