import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun ListProducts(modifier: Modifier = Modifier, product: String, stock: String, onClick: () -> Unit) {
    LazyColumn {
        items(25) {
            Row(modifier = Modifier
                .padding(bottom = 18.dp)
                .clickable { onClick() }) {
                Text(
                    text = product,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stock,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                    )
                )
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "Detail",
                    tint = Black,
                )
            }
        }
    }
}