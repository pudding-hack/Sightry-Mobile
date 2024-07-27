import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.example.sightry.ui.theme.Blue
import com.example.sightry.ui.theme.Orange
import com.example.sightry.ui.theme.Purple
import com.example.sightry.ui.theme.Red

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LogoWTextComp()
        Spacer(modifier = Modifier.height(24.dp))
        HomeButton(text = "Cek Stock Barang", onClick = {
            navController.navigate(NavigationItem.Camera.route)
        }, color = Red)
        Spacer(modifier = Modifier.height(16.dp))
        HomeButton(text = "List Stock Barang", onClick = {

        }, color = Blue)
        Spacer(modifier = Modifier.height(16.dp))
        HomeButton(text = "Tambah Stock", onClick = {

        }, color = Purple)
        Spacer(modifier = Modifier.height(16.dp))
        HomeButton(text = "Stock Keluar", onClick = {

        }, color = Orange)
    }
}
