package ar.com.wolox.android.example.utils

import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun ProgressBar.toggleVisibilityAnimation(toggle: Boolean) {
    this.visibility = if (toggle) View.VISIBLE else View.GONE
}

fun RecyclerView.infiniteScroll(onNearToTheEnd: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            if (dy > 0) {
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = linearLayoutManager.childCount
                val pastVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                val totalItems = adapter!!.itemCount
                if ((visibleItemCount + pastVisibleItem) >= totalItems) {
                    onNearToTheEnd.invoke()
                }
            }
        }
    })
}