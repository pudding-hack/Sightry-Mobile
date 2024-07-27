package com.example.sightry.navigation.screens

import AppBar
import FilledButton
import ListProducts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ListStockBarangCountScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AppBar(text = "List Stock Barang", onIconClick = {
            navController.popBackStack()
        })
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            ListProducts(product = "Pasta Gigi", stock = "10 Buah", onClick = {
                navController.navigate(NavigationItem.Edit.route)
            })
        }
        Spacer(modifier = Modifier.height(26.dp))
        FilledButton(text = "Tambah Stock", onClick = {

        })
    }
}
