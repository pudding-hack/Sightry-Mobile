package com.example.sightry.data.remote

import RecognitionResponse
import com.example.sightry.data.remote.dto.request.RecognitionRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType

class inventoryServiceImpl(
    private val client: HttpClient
): InventoryService {
    override suspend fun recognition(recognitionRequest: RecognitionRequest): RecognitionResponse? {
        try {
            return client.post{
                url(HttpRoutes.RECOGNITION)
                contentType(ContentType.Application.Json)
                setBody(recognitionRequest)
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