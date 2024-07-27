import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun AppBar(modifier: Modifier = Modifier, text: String, onIconClick: () -> Unit) {
    Column (modifier = Modifier.padding(top = 12.dp)) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back",
                tint = Black,
                modifier = Modifier.clickable { onIconClick() }
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                    fontWeight = FontWeight(600),
                    color = Black,
                )
            )
        }
    }
}
