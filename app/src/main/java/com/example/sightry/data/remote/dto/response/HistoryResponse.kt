import kotlinx.serialization.*

@Serializable
data class HistoryResponse (
    @SerialName("status_code")
    val statusCode: Long,

    val message: String,
    val data: DataHistory
)

@Serializable
data class DataHistory (
    val data: List<DatumHistory>,
    val meta: Meta
)

@Serializable
data class DatumHistory (
    val id: Long,

    @SerialName("item_id")
    val itemID: Long,

    val qty: Long,

    @SerialName("qty_before")
    val qtyBefore: Long,

    @SerialName("qty_after")
    val qtyAfter: Long,

    @SerialName("type_id")
    val typeID: Long,

    val type: String,

    @SerialName("created_at")
    val createdAt: String
)

@Serializable
data class Meta (
    val page: Long,

    @SerialName("page_size")
    val pageSize: Long,

    val total: Long,

    @SerialName("total_page")
    val totalPage: Long,

    @SerialName("total_data")
    val totalData: Long
)
