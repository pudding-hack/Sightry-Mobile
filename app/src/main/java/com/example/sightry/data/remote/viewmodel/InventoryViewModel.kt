package com.example.sightry.ui.viewmodel

import InventoryResponse
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sightry.data.remote.InventoryService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class InventoryViewModel : ViewModel() {
    private val _inventoryState = MutableStateFlow<InventoryResponse?>(null)
    val inventoryState: StateFlow<InventoryResponse?> = _inventoryState

    fun fetchInventory(context: Context) {
        viewModelScope.launch {
            val inventoryService = InventoryService.create()
            try {
                val response = inventoryService.getInventory(context)
                _inventoryState.value = response
            } catch (e: Exception) {
                Log.e("ListStockBarangScreen", "Failed to fetch inventory: ${e.message}")
            }
        }
    }
}
