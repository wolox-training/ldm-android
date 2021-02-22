package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("data") val data: UserData)