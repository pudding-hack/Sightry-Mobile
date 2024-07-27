enum class Screen {
    SPLASH,
    LOGIN,
    HOME,
    CAMERA,
    RESULT,
    LIST,
    Detail
}

sealed class NavigationItem(val route: String) {
    object Splash : NavigationItem(Screen.SPLASH.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Home : NavigationItem(Screen.HOME.name)
    object Camera : NavigationItem(Screen.CAMERA.name)
    object Result : NavigationItem(Screen.RESULT.name)
    object List : NavigationItem(Screen.LIST.name)
    object Detail : NavigationItem(Screen.Detail.name)
}