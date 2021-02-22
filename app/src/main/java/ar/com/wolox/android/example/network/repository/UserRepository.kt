package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.model.UserAuth

import ar.com.wolox.android.example.network.NetworkHeaders
import ar.com.wolox.android.example.network.services.UserService
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkRequestHandler
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val retrofitServices: RetrofitServices, private val userSession: UserSession) {

    private val service: UserService
        get() = retrofitServices.getService(UserService::class.java)

    suspend fun authUser(email: String, password: String) = withContext(Dispatchers.IO) {
        val response = NetworkRequestHandler.safeApiCall { service.authUser(UserAuth(email, password)) }
        if (response is NetworkResponse.Success) {
            userSession.accessToken = response.response.headers()[NetworkHeaders.ACCESS_TOKEN]
            userSession.client = response.response.headers()[NetworkHeaders.CLIENT]
            userSession.uid = response.response.headers()[NetworkHeaders.UID]
        }
        response
    }
}