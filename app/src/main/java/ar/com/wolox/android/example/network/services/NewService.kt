package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.NewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewService {
    @GET("/comments")
    suspend fun getNews(@Query("page") page: Int): Response<NewsPage>

/*    @GET("/comments/{id}")
    suspend fun getNew(@Body credentials: TokenAuth, @Path("id") id: Int): Response<New>

    @PUT
    suspend fun putLike(@Body credentials: TokenAuth): Response<New>*/
}