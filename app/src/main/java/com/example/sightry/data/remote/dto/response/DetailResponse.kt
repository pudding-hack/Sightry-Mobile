import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class DetailResponse (
    @SerialName("status_code")
    val statusCode: Long,

    val message: String,
    val data: DataDetail
)

@Serializable
data class DataDetail (
    val id: Long,

    @SerialName("item_code")
    val itemCode: String,

    @SerialName("item_name")
    val itemName: String,

    val qty: Long,

    @SerialName("unit_id")
    val unitID: Long,

    val unit: String,
    val price: Long
)