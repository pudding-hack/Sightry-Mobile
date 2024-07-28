import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sightry.ui.viewmodel.InventoryViewModel

@Composable
fun ListStockBarangScreen(navController: NavHostController) {
    val context = LocalContext.current
    val inventoryViewModel: InventoryViewModel = viewModel()
    val inventoryState = inventoryViewModel.inventoryState.collectAsState()

    remember { inventoryViewModel.fetchInventory(context) }

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
            inventoryState.value?.let { inventoryResponse ->
                ListProducts(
                    inventory = inventoryResponse.data,
                    onClick = {
                        navController.navigate(NavigationItem.Detail.route)
                    }
                )
            }
        }
    }
}
