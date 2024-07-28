package com.example.sightry.data.remote

import DetailResponse
import HistoryResponse
import InventoryResponse
import RecognitionResponse
import android.content.Context
import com.example.sightry.data.remote.dto.request.RecognitionRequest
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface InventoryService {
    suspend fun recognition(recognitionRequest: RecognitionRequest, context: Context): RecognitionResponse?

    suspend fun getInventory(context: Context): InventoryResponse?

    suspend fun getByIdInventory(id: Long, context: Context): DetailResponse?

    suspend fun historyInventory(id: Long, context: Context): HistoryResponse?

    companion object {
        fun create(): InventoryService {
            return InventoryServiceImpl(client = HttpClient(Android){
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
                install(HttpTimeout) {
                    requestTimeoutMillis = 60000
                    connectTimeoutMillis = 60000
                    socketTimeoutMillis = 60000
                }
            })
        }
    }
}