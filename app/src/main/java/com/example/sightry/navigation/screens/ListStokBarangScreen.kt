import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sightry.ui.viewmodel.InventoryViewModel

@SuppressLint("RememberReturnType")
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
                    onClick = { product ->
                        navController.currentBackStackEntry?.savedStateHandle?.set("id", product.id)
                        navController.navigate(NavigationItem.Detail.route)
                    }
                )
            }
        }
    }
}

