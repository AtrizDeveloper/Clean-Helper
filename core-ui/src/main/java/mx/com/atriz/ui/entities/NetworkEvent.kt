package mx.com.atriz.ui.entities
import java.io.Serializable

data class NetworkEvent(
    val internet: Boolean,
    val wifi: Boolean,
    val network: Boolean
) : Serializable