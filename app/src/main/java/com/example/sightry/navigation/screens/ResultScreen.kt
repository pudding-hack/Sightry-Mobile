import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sightry.R
import com.example.sightry.ui.theme.Black
import com.example.sightry.ui.theme.Grey
import java.io.InputStream

@Composable
fun ResultScreen(navController: NavHostController) {
    val context = LocalContext.current
    val imageUriString = navController.previousBackStackEntry?.savedStateHandle?.get<String>("imageUri") ?: return
    val imageUri = Uri.parse(imageUriString)

    val inputStream: InputStream? = remember { context.contentResolver.openInputStream(imageUri) }
    val bitmap = remember {
        inputStream?.use { BitmapFactory.decodeStream(it) }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(700.dp)
                    .background(color = Grey, shape = RoundedCornerShape(size = 34.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    bitmap = bitmap?.asImageBitmap() ?: return@Column,
                    contentDescription = "Captured Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(34.dp))
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Pasta gigi memiliki 5 stok barang",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                    fontWeight = FontWeight(400),
                    color = Black,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}
