package com.example.sightry.data.remote

import com.example.sightry.data.remote.dto.request.LoginRequest
import com.example.sightry.data.remote.dto.response.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthServiceImpl(
    private val client: HttpClient
): AuthService {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse? {
        try {
            return client.post{
                url(HttpRoutes.LOGIN)
                contentType(ContentType.Application.Json)
                setBody(loginRequest)
            }.body()
        } catch (e: RedirectResponseException) {
            // 3xx responses
            println("Error: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            // 4xx responses
            println("Error: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            // 5xx responses
            println("Error: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            // General exception
            println("Error: ${e.message}")
            return null
        }
    }
}