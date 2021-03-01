package ar.com.wolox.android.example.model

data class NewData(
    val id: Int,
    val commenter: String,
    val comment: String,
    val date: String,
    val avatar: String,
    val likes: ArrayList<String>,
    val createdAt: String,
    val updatedAt: String
)