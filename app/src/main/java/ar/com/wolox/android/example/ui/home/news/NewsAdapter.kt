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
import ar.com.wolox.android.example.utils.formatTime
import kotlin.collections.ArrayList

class NewsAdapter(dataSet: ArrayList<New>, private val newsView: NewsView) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var news: ArrayList<New> = dataSet

    fun updateNews(newNews: ArrayList<New>) {
        news = newNews
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val commenter: TextView = view.findViewById(R.id.newsTitle)
        val comment: TextView = view.findViewById(R.id.newsBody)
        val image: ImageView = view.findViewById(R.id.newsImage)
        val timeAgo: TextView = view.findViewById(R.id.newsTimeAgo)
        val likeState: ToggleButton = view.findViewById(R.id.newsLikeButton)
        var id: Int = ID_START_VALUE
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
            viewHolder.id = it.id
            viewHolder.commenter.text = it.commenter
            viewHolder.comment.text = it.comment
            viewHolder.timeAgo.text = it.date.formatTime()
            viewHolder.likeState.isChecked = newsView.toggleLikeButton(it.likes)
        }
        viewHolder.itemView.setOnClickListener {
            newsView.goToNewDetail(viewHolder.id)
        }
        viewHolder.likeState.setOnClickListener {
            newsView.onUpdateLike(viewHolder.id)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size

    companion object {
        const val ID_START_VALUE: Int = -1
    }
}
