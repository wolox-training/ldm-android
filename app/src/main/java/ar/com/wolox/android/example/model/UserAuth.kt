package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class UserAuth(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)