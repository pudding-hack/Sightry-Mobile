import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import androidx.navigation.NavHostController
import com.example.sightry.R
import com.example.sightry.data.remote.InventoryService
import com.example.sightry.data.remote.dto.request.RecognitionRequest
import com.example.sightry.ui.theme.Black
import com.example.sightry.ui.theme.Grey
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.launch
import java.io.InputStream

@Composable
fun ResultScreen(navController: NavHostController) {
    val context = LocalContext.current
    val imageUriString = navController.previousBackStackEntry?.savedStateHandle?.get<String>("imageUri") ?: return
    val base64Image = navController.previousBackStackEntry?.savedStateHandle?.get<String>("base64Image") ?: return
    val imageUri = Uri.parse(imageUriString)

    val inputStream: InputStream? = remember { context.contentResolver.openInputStream(imageUri) }
    val bitmap = remember {
        inputStream?.use { BitmapFactory.decodeStream(it) }
    }

    var recognitionResponse by remember { mutableStateOf<RecognitionResponse?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val inventoryService = InventoryService.create()

    LaunchedEffect(base64Image) {
        coroutineScope.launch {
            try {
                val recognitionRequest = RecognitionRequest(imageBase64 = "data:image/jpeg;base64,$base64Image")
                Log.d("ResultScreen", "Sending request: $recognitionRequest")
                recognitionResponse = inventoryService.recognition(recognitionRequest, context)
                Log.d("ResultScreen", "Recognition API response: $recognitionResponse")
            } catch (e: RedirectResponseException) {
                Log.e("ResultScreen", "3xx response: ${e.response.status.description}", e)
            } catch (e: ClientRequestException) {
                Log.e("ResultScreen", "4xx response: ${e.response.status.description}", e)
            } catch (e: ServerResponseException) {
                Log.e("ResultScreen", "5xx response: ${e.response.status.description}", e)
            } catch (e: Exception) {
                Log.e("ResultScreen", "API call failed: ${e.message}", e)
            }
        }
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
            recognitionResponse?.let {
                Text(
                    text = "${it.data.itemName} memiliki ${it.data.qty} stock barang",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.lexend)),
                        fontWeight = FontWeight(400),
                        color = Black,
                        textAlign = TextAlign.Center,
                    )
                )
            } ?: Text(
                text = "Barang belum terdaftar",
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
