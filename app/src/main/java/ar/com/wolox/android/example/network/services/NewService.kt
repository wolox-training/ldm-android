package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.New
import ar.com.wolox.android.example.model.NewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface NewService {
    @GET("/comments")
    suspend fun getNews(@Query("page") page: Int): Response<NewsPage>

    @GET("/comments/{id}")
    suspend fun getNew(@Path("id") id: Int): Response<New>

    @PUT("/comments/like/{id}")
    suspend fun updateLike(@Path("id") id: Int): Response<Any>
}