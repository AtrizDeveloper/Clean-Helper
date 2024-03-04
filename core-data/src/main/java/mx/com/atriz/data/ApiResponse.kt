package mx.com.atriz.data

sealed class ApiResponse<T> {
    class Success<T>(val data: T) : ApiResponse<T>()

    class Error<T>(val msg: String, val code: Int): ApiResponse<T>()
    class Network<T> : ApiResponse<T>()
    class SessionExpired<T> : ApiResponse<T>()
    class Timeout<T> : ApiResponse<T>()
}