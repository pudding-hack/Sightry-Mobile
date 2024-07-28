import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sightry.R
import com.example.sightry.ui.theme.Black
import com.example.sightry.ui.viewmodel.InventoryViewModel

@SuppressLint("RememberReturnType")
@Composable
fun DetailBarangScreen(navController: NavHostController) {
    val context = LocalContext.current
    val inventoryViewModel: InventoryViewModel = viewModel()

    val id = navController.previousBackStackEntry?.savedStateHandle?.get<Long>("id") ?: return

    val detailState = inventoryViewModel.detailState.collectAsState()
    val historyState = inventoryViewModel.historyState.collectAsState()

    remember {
        inventoryViewModel.fetchDetailInventory(id, context)
        inventoryViewModel.fetchHistoryInventory(id, context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AppBar(text = "Detail Barang", onIconClick = {
            navController.popBackStack()
        })
        Spacer(modifier = Modifier.height(30.dp))

        detailState.value?.let { detailResponse ->
            Row(modifier = Modifier.padding(bottom = 22.dp)) {
                Text(
                    text = detailResponse.data.itemName,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${detailResponse.data.qty} buah",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
            }
        }

        HorizontalDivider()
        Spacer(modifier = Modifier.height(22.dp))

        Row(modifier = Modifier.padding(bottom = 24.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_history),
                contentDescription = "Riwayat",
                tint = Black,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Riwayat Barang",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                    fontWeight = FontWeight(400),
                    color = Black,
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            historyState.value?.let { historyResponse ->
                ListHistories(histories = historyResponse.data.data)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        FilledButton(text = "Tambah Stock", onClick = {

        })
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(text = "Keluar Stock", onClick = {

        })
    }
}
