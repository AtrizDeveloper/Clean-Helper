package mx.com.atriz.domain.entities

data class Device(
    val uid: String,
    val model: String,
    val brand: String,
    val soVersion: String,
    val appVersion: String
)
