package com.example.sightry.data.remote

import RecognitionResponse
import com.example.sightry.data.remote.dto.request.RecognitionRequest

interface InventoryService {
    suspend fun recognition(recognitionRequest: RecognitionRequest): RecognitionResponse?
}