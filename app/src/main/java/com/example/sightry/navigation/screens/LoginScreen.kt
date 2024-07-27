import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.sightry.ui.theme.DarkBlue
import com.example.sightry.ui.theme.White

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        LogoWTextComp()
        Spacer(modifier = Modifier.height(73.dp))
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = "Username",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.lexend)),
                fontWeight = FontWeight(400),
                color = Black,
            )
        )
        Spacer(modifier = Modifier.height(11.dp))
        Row {
            OutlinedTextField(
                value = "",
                onValueChange = { /*TODO*/ },
                shape = RoundedCornerShape(100.dp),
                label = {
                    Text("Masukkan Username")
                }, modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp, start = 10.dp)

            )
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = "Password",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.lexend)),
                fontWeight = FontWeight(400),
                color = Black,
            )
        )
        Spacer(modifier = Modifier.height(11.dp))
        Row {
            OutlinedTextField(
                value = "",
                onValueChange = { /*TODO*/ },
                shape = RoundedCornerShape(100.dp),
                label = {
                    Text("Masukkan Password")
                }, modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp, start = 10.dp)

            )
        }
        Spacer(modifier = Modifier.height(73.dp))
        FilledButton(
            text = "Masuk",
            onClick = { navController.navigate(NavigationItem.Home.route) })
    }
}