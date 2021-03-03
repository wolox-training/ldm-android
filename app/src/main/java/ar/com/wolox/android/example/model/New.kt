package ar.com.wolox.android.example.model
import kotlin.collections.ArrayList

data class New(
    val id: Int,
    val commenter: String,
    val comment: String,
    var date: String,
    val avatar: String,
    val likes: ArrayList<String>,
    val createdAt: String,
    val updatedAt: String
)