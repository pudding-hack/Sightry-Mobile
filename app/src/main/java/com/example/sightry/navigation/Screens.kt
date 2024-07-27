enum class Screen {
    SPLASH,
    LOGIN,
    HOME,
    CAMERA,
    RESULT,
    LIST,
    DETAIL,
    ADD,
    MIN,
    EDIT,
}

sealed class NavigationItem(val route: String) {
    object Splash : NavigationItem(Screen.SPLASH.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Home : NavigationItem(Screen.HOME.name)
    object Camera : NavigationItem(Screen.CAMERA.name)
    object Result : NavigationItem(Screen.RESULT.name)
    object List : NavigationItem(Screen.LIST.name)
    object Detail : NavigationItem(Screen.DETAIL.name)
    object Add : NavigationItem(Screen.ADD.name)
    object Min : NavigationItem(Screen.MIN.name)
    object Edit : NavigationItem(Screen.EDIT.name)
}