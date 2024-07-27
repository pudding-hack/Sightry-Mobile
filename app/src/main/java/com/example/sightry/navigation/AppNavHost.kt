import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Min.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Login.route) {
            LoginScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Camera.route) {
            CameraScreen(navController)
        }
        composable(NavigationItem.Result.route) {
            ResultScreen(navController)
        }
        composable(NavigationItem.List.route) {
            ListStockBarangScreen(navController)
        }
        composable(NavigationItem.Detail.route) {
            DetailBarangScreen(navController)
        }
        composable(NavigationItem.Add.route) {
            AddScreen(navController)
        }
        composable(NavigationItem.Min.route) {
            MinScreen(navController)
        }
        composable(NavigationItem.Edit.route) {
            EditScreen(navController)
        }
    }
}

