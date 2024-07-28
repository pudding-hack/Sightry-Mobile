package com.example.sightry.data.remote

import DetailResponse
import HistoryResponse
import IOResponse
import InventoryResponse
import RecognitionResponse
import TokenManager
import android.content.Context
import android.util.Log
import com.example.sightry.data.remote.dto.request.IORequest
import com.example.sightry.data.remote.dto.request.RecognitionRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

class InventoryServiceImpl(
    private val client: HttpClient
): InventoryService {
    override suspend fun recognition(recognitionRequest: RecognitionRequest, context: Context): RecognitionResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.post{
                url(HttpRoutes.RECOGNITION)
                header("Authorization", "Bearer $token")
                contentType(ContentType.Application.Json)
                setBody(recognitionRequest)
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }
    }

    override suspend fun getInventory(context: Context): InventoryResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.get{
                url(HttpRoutes.INVENTORY)
                header("Authorization", "Bearer $token")
                contentType(ContentType.Application.Json)
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }

    }

    override suspend fun getByIdInventory(id: Long, context: Context): DetailResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.get{
                url(HttpRoutes.DETAIL)
                header("Authorization", "Bearer $token")
                parameter("id", id)
                contentType(ContentType.Application.Json)
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }

    }

    override suspend fun historyInventory(id: Long, context: Context): HistoryResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.get{
                url(HttpRoutes.HISTORY)
                header("Authorization", "Bearer $token")
                parameter("id", id)
                contentType(ContentType.Application.Json)
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }

    }

    override suspend fun inboundInventory(ioRequest: IORequest, context: Context): IOResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.post {
                url(HttpRoutes.INBOUND)
                header("Authorization", "Bearer $token")
                contentType(ContentType.Application.Json)
                setBody(ioRequest) // Correctly pass the ioRequest object
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }
    }

    override suspend fun outboundInventory(ioRequest: IORequest, context: Context): IOResponse? {
        val tokenManager = TokenManager(context)
        val token: String?
        try {
            token = tokenManager.getAccessToken()
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl Token", "Failed to retrieve access token: $e")
            return null
        }
        try {
            val response =  client.post {
                url(HttpRoutes.OUTBOUND)
                header("Authorization", "Bearer $token")
                contentType(ContentType.Application.Json)
                setBody(ioRequest) // Correctly pass the ioRequest object
            }
            Log.d("InventoryServiceImpl", "API response: $response")
            return response.body()
        } catch (e: RedirectResponseException) {
            Log.e("InventoryServiceImpl ", "3xx: ${e.response.status.description}")
            return null
        } catch (e: ClientRequestException) {
            Log.e("InventoryServiceImpl ", "4xx: ${e.response.status.description}")
            return null
        } catch (e: ServerResponseException) {
            Log.e("InventoryServiceImpl", "5xx: ${e.response.status.description}")
            return null
        } catch (e: Exception) {
            Log.e("InventoryServiceImpl", "Error: ${e.message}")
            return null
        }
    }
}