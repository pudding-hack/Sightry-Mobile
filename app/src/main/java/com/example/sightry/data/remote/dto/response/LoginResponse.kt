package com.example.sightry.data.remote.dto.response

import kotlinx.serialization.*

@Serializable
data class LoginResponse (
    @SerialName("status_code")
    val statusCode: Long,
    val message: String,
    val data: Data
)

@Serializable
data class Data (
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String,
    val user: User
)

@Serializable
data class User (
    val id: String,
    val name: String,
    val phone: String,
    val username: String,
    val email: String,
    val role: Role,
    val signature: String
)

@Serializable
data class Role (
    val id: Long,
    val name: String
)