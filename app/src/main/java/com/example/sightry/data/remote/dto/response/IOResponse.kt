import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class IOResponse (
    @SerialName("status_code")
    val statusCode: Long,

    val message: String
)
