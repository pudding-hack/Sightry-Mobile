import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sightry.data.remote.AuthService
import com.example.sightry.data.remote.dto.request.LoginRequest
import com.example.sightry.data.remote.dto.response.LoginResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.first

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
        viewModelScope.launch {
            val loginRequest = LoginRequest(
                username = _loginState.value.username,
                password = _loginState.value.password
            )
            val response = authService.login(loginRequest)
            if (response != null) {
                saveUserData(context, response)
            }
        }
    }

    private suspend fun saveUserData(context: Context, loginResponse: LoginResponse) {
        val dataStore = context.dataStore
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey("access_token")] = loginResponse.data.accessToken
            preferences[stringPreferencesKey("refresh_token")] = loginResponse.data.refreshToken
            preferences[stringPreferencesKey("username")] = loginResponse.data.user.username
        }
    }
}

data class LoginState(
    val username: String = "",
    val password: String = ""
)
