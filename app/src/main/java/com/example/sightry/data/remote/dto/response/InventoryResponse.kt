import kotlinx.serialization.*

@Serializable
data class InventoryResponse (
    @SerialName("status_code")
    val statusCode: Long,

    val message: String,
    val data: List<Datum>
)

@Serializable
data class Datum (
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