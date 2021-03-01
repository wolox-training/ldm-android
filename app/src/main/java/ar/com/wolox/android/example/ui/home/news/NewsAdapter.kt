package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.New
import kotlin.random.Random

class NewsAdapter(private val dataSet: ArrayList<New>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var news: ArrayList<New> = dataSet

    private fun ArrayList<New>.prependAll(l: ArrayList<New>) {
        l.forEach { any -> add(0, any) }
    }

    fun updateNews(newNews: ArrayList<New>) {
        // newNews were sorted by time in the presenter
        news = newNews
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
        val likeState: ToggleButton = view.findViewById(R.id.newsLikeButton)
        // Define click listener for the ViewHolder's View.
        init {}
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
            if (Random.nextInt(0, 10) > 4) {
                viewHolder.likeState.toggle()
            }
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size
}