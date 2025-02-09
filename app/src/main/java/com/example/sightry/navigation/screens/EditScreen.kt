import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

@Composable
fun EditScreen(navController: NavHostController) {
    var textFieldValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        AppBar(text = "Ubah Detail Barang", onIconClick = {
            navController.popBackStack()
        })
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Ubah Jumlah Pasta Gigi",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.lexend)),
                fontWeight = FontWeight(600),
                color = Black,
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(34.dp)),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                textStyle = TextStyle(
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.lexend)),
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
                ),
                placeholder = {
                    Text(
                        text = "Masukkan angka disini...",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.lexend)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA6A6A6),
                            textAlign = TextAlign.Center
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Grey, RoundedCornerShape(34.dp))
                    .padding(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedPlaceholderColor = Color(0xFFA6A6A6),
                    unfocusedPlaceholderColor = Color(0xFFA6A6A6),
                    focusedContainerColor = Grey,
                    unfocusedContainerColor = Grey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Black,
                    unfocusedTextColor = Black,
                )
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        FilledButton(text = "Submit", onClick = { })
    }
}