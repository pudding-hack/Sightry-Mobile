import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sightry.data.remote.AuthService
import com.example.sightry.data.remote.dto.request.LoginRequest
import com.example.sightry.data.remote.dto.response.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val authService: AuthService = AuthService.create()) : ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun onUsernameChange(username: String) {
        _loginState.value = _loginState.value.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        _loginState.value = _loginState.value.copy(password = password)
    }

    fun login(context: Context) {
        val tokenManager = TokenManager(context)
        viewModelScope.launch {
            val loginRequest = LoginRequest(
                username = _loginState.value.username,
                password = _loginState.value.password
            )
            val response = authService.login(loginRequest)
            if (response != null) {
                saveUserData(tokenManager, response)
            }
        }
    }

    private suspend fun saveUserData(tokenManager: TokenManager, loginResponse: LoginResponse) {
        tokenManager.saveAccessToken(loginResponse.data.accessToken)
        tokenManager.saveRefreshToken(loginResponse.data.refreshToken)
        tokenManager.saveUsername(loginResponse.data.user.username)
    }
}

data class LoginState(
    val username: String = "",
    val password: String = ""
)
