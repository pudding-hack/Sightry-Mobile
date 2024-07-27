import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sightry.R
import com.example.sightry.ui.theme.Black
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {
    val state by viewModel.loginState.collectAsState()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var passwordVisible by remember { mutableStateOf(false) }

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
        OutlinedTextField(
            value = state.username,
            onValueChange = { viewModel.onUsernameChange(it) },
            shape = RoundedCornerShape(100.dp),
            label = { Text("Masukkan Username") },
            textStyle = TextStyle(color = Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
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
        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            shape = RoundedCornerShape(100.dp),
            label = { Text("Masukkan Password") },
            textStyle = TextStyle(color = Black),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible)
                    Icon(painter = painterResource(id = R.drawable.ic_visibility), contentDescription = null)
                else Icon(painter = painterResource(id = R.drawable.ic_visibility_off), contentDescription = null)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    icon
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(73.dp))
        FilledButton(
            text = "Masuk",
            onClick = {
                coroutineScope.launch {
                    viewModel.login(context)
                    navController.navigate(NavigationItem.Home.route)
                }
            }
        )
    }
}
