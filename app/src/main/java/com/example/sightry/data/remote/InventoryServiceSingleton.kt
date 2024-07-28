package com.example.sightry.data.remote

object InventoryServiceSingleton {
    val inventoryService: InventoryService by lazy {
        InventoryService.create()
    }
}
