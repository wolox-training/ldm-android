package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News

class NewsAdapter(private val dataSet: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private val news: MutableList<News> = dataSet.toMutableList()

    private fun MutableList<News>.prependAll(l: List<News>) {
        l.forEach { any -> add(0, any) }
    }

    fun updateNews(newNews: List<News>) {
        news.prependAll(newNews)
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.newsTitle)
        val body: TextView = view.findViewById(R.id.newsBody)
        val image: ImageView = view.findViewById(R.id.newsImage)
        val timeAgo: TextView = view.findViewById(R.id.newsTimeAgo)

        init {
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        news[position].also {
            viewHolder.title.text = it.title
            viewHolder.body.text = it.body
            viewHolder.timeAgo.text = it.time
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size
}