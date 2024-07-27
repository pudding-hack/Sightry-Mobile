package com.example.sightry.data.remote

import com.example.sightry.data.remote.dto.request.LoginRequest
import com.example.sightry.data.remote.dto.response.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface AuthService {
    suspend fun login(loginRequest: LoginRequest): LoginResponse?

    companion object {
        fun create(): AuthService {
            return AuthServiceImpl(client = HttpClient(Android){
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
            })
        }
    }
}