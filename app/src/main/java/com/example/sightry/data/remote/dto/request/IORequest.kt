package com.example.sightry.data.remote.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class IORequest(
    val id: Long,
    val qty: Long
)
