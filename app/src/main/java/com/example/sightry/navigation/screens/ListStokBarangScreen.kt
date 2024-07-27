import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ListStockBarangScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AppBar(text = "List Stock Barang", onIconClick = {
            navController.popBackStack()
        })
        Spacer(modifier = Modifier.height(30.dp))
        ListProducts(product = "Pasta Gigi", stock = "10 Buah", onClick = {
            navController.navigate(NavigationItem.Detail.route)
        })
    }
}
