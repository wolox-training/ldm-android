package ar.com.wolox.android.example.utils

import org.joda.time.format.DateTimeFormat
import org.ocpsoft.prettytime.PrettyTime
import java.util.Locale

fun String.formatTime(): String? {
    val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
    val dateTime = formatter.parseDateTime(this)
    val prettyTime = PrettyTime(Locale.getDefault())
    return prettyTime.format(dateTime.toDate())
}