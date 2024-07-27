import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sightry.R
import com.example.sightry.ui.theme.Black

@Composable
fun DetailBarangScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AppBar(text = "Detail Barang", onIconClick = {
            navController.popBackStack()
        })
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.padding(bottom = 22.dp)) {
            Text(
                text = "Pasta gigi",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                    fontWeight = FontWeight(400),
                    color = Black,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "10 buah",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                    fontWeight = FontWeight(400),
                    color = Black,
                )
            )
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
            ListHistories()
        }
        Spacer(modifier = Modifier.height(16.dp))
        FilledButton(text = "Tambah Stock", onClick = {

        })
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(text = "Keluar Stock", onClick = {

        })
    }
}