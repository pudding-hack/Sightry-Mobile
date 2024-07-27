import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sightry.R
import com.example.sightry.ui.theme.Black

@Composable
fun LogoWTextComp(modifier: Modifier = Modifier) {
    Image(
        painterResource(R.drawable.logo),
        contentDescription = null,
        modifier = Modifier.size(64.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Sightry",
        style = TextStyle(
            fontSize = 25.63.sp,
            fontFamily = FontFamily(Font(R.font.lexend)),
            fontWeight = FontWeight(600),
            color = Black,
            textAlign = TextAlign.Center,
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Inventarisasi Mudah untuk Semua",
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.lexend)),
            fontWeight = FontWeight(400),
            color = Black,
        )
    )
}