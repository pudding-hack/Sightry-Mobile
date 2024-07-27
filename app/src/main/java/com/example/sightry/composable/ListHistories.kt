import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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

@Composable
fun ListHistories(modifier: Modifier = Modifier) {
    LazyColumn {
        items(25){
            Row(modifier = Modifier.padding(bottom = 22.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "Tambah",
                    tint = Green,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "2 Juni 2024 barang bertambah sebanyak 5 buah",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
            }
        }
    }
}