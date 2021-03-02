package ar.com.wolox.android.example.ui.home.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.NewData
import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale
import kotlin.collections.ArrayList

class NewsAdapter(private val dataSet: ArrayList<NewData>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var news: ArrayList<NewData> = dataSet

    private var prettyTime = PrettyTime()

    fun updateNews(newNews: ArrayList<NewData>) {
        // newNews were sorted by time in the presenter
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

    private fun formatTime(date: String): String? {
        val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
        val dateTime = formatter.parseDateTime(date)
        val prettyTime = PrettyTime(Locale.getDefault())
        return prettyTime.format(dateTime.toDate())
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        news[position].also {
            viewHolder.commenter.text = it.commenter
            viewHolder.comment.text = it.comment
            viewHolder.timeAgo.text = formatTime(it.date)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = news.size
}
