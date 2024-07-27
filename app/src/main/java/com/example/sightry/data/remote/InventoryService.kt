package com.example.sightry.data.remote

import RecognitionResponse
import android.content.Context
import com.example.sightry.data.remote.dto.request.RecognitionRequest

interface InventoryService {
    suspend fun recognition(recognitionRequest: RecognitionRequest, context: Context): RecognitionResponse?
}