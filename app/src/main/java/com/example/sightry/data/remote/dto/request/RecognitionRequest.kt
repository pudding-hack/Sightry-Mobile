package com.example.sightry.data.remote.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecognitionRequest (
    @SerialName("image_base64")
    val imageBase64: String
)