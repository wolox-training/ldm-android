package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class NewsPage(
    @SerializedName("page") val page: ArrayList<NewData>,
    @SerializedName("current_page") val currentPage: Int
)