package com.example.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(val id: Int, val login: String, @SerialName("avatar_url") val avatarUrl: String)