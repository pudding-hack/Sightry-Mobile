package com.example.sightry.data.remote

object HttpRoutes {
    const val BASE_URL = "https://puddinghack.varomnrg.me/api"
    const val LOGIN = "$BASE_URL/auth/login"
    const val INVENTORY = "$BASE_URL/inventory"
    const val HISTORY = "$BASE_URL/inventory/history"
    const val DETAIL = "$BASE_URL/inventory/detail"
    const val INBOUND = "$BASE_URL/inventory/inbound"
    const val OUTBOUND = "$BASE_URL/inventory/outbound"
    const val RECOGNITION = "$BASE_URL/inventory/rekognition"
}