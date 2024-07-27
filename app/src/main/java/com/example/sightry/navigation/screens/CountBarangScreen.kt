import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavController
import com.example.sightry.R
import com.example.sightry.ui.theme.Black
import com.example.sightry.ui.theme.Grey
import java.io.InputStream

@Composable
fun CountBarangScreen(navController: NavController) {
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
                    .weight(1f)
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
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)){
                ListCountDetail(product = "Pasta Gigi", stock = "10 buah")
            }
            Spacer(modifier = Modifier.height(16.dp))
            FilledButton(text = "Tambah Stock", onClick = {

            })
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(text = "Keluar Stock", onClick = {

            })
        }
    }
}