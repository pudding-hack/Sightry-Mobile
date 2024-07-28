import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sightry.R
import com.example.sightry.ui.theme.Black
import com.example.sightry.ui.theme.Green
import com.example.sightry.ui.theme.Red

@Composable
fun ListHistories(histories: List<DatumHistory>) {
    LazyColumn {
        items(histories) {history ->
            Row(modifier = Modifier.padding(bottom = 22.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(
                        id = if (history.type == "Inbound") R.drawable.ic_plus else R.drawable.ic_minus
                ),
                contentDescription = if (history.type == "Inbound") "Tambah" else "Kurang",
                tint = if (history.type == "Inbound") Green else Red,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "${history.createdAt} barang ${if (history.type == "Inbound") "bertambah" else "berkurang"} sebanyak ${history.qty} buah",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
        }
    }
}}