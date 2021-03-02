package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class NewsPage(
        @SerializedName("page") val page: ArrayList<New>,
        @SerializedName("current_page") val currentPage: Int,
        @SerializedName("total_pages") val totalPages: Int
)