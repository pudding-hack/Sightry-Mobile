package com.example.sightry.ui.viewmodel

import DetailResponse
import HistoryResponse
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

    private val inventoryService: InventoryService = InventoryService.create()

    private val _detailState = MutableStateFlow<DetailResponse?>(null)
    val detailState: StateFlow<DetailResponse?> get() = _detailState

    private val _historyState = MutableStateFlow<HistoryResponse?>(null)
    val historyState: StateFlow<HistoryResponse?> get() = _historyState

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

    fun fetchDetailInventory(id: Long, context: Context) {
        viewModelScope.launch {
            try {
                _detailState.value = inventoryService.getByIdInventory(id, context)
            } catch (e: Exception) {
                Log.e("InventoryViewModel", "Error fetching detail: ${e.message}")
            }
        }
    }

    fun fetchHistoryInventory(id: Long, context: Context) {
        viewModelScope.launch {
            try {
                _historyState.value = inventoryService.historyInventory(id, context)
            } catch (e: Exception) {
                Log.e("InventoryViewModel", "Error fetching history: ${e.message}")
            }
        }
    }

}
