package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.model.UserAuth
import ar.com.wolox.android.example.network.services.UserService
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkRequestHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    private val service: UserService
        get() = retrofitServices.getService(UserService::class.java)

    suspend fun authUser(email: String, password: String) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { service.authUser(UserAuth(email, password)) }
    }
}