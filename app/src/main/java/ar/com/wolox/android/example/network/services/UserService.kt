package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.example.model.User
import ar.com.wolox.android.example.model.UserAuth
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/auth/sign_in")
    suspend fun authUser(@Body userAuth: UserAuth): Response<User>
}