package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("email") val email: String,
    @SerializedName("id") val id: Int,
    @SerializedName("provider") val provider: String,
    @SerializedName("uid") val uid: String,
    @SerializedName("allow_password_change") val allowPasswordChange: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("image") val image: String?
)