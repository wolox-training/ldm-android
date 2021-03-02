package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class TokenAuth(
    @SerializedName("accessToken") val accessToken: String,
    @SerializedName("uid") val uid: String,
    @SerializedName("client") val client: String
)
