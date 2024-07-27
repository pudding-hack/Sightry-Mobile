import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class TokenManager(private val context: Context) {

    private val dataStore = context.dataStore

    val accessToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN]
        }

    val refreshToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[PreferencesKeys.REFRESH_TOKEN]
        }

    val username: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[PreferencesKeys.USERNAME]
        }

    suspend fun saveAccessToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN] = token
        }
    }

    suspend fun saveRefreshToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.REFRESH_TOKEN] = token
        }
    }

    suspend fun saveUsername(username: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.USERNAME] = username
        }
    }

    suspend fun getAccessToken(): String? {
        return accessToken.first()
    }

    suspend fun clearTokens() {
        dataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.ACCESS_TOKEN)
            preferences.remove(PreferencesKeys.REFRESH_TOKEN)
            preferences.remove(PreferencesKeys.USERNAME)
        }
    }
}
