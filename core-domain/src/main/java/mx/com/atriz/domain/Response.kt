package mx.com.atriz.domain

sealed class Response<T> {
    class Success<T>(val data: T) : Response<T>()
    class Failure<T>(val error: Error ) : Response<T>()

    enum class Error(val value: Int){
        Unknown(0),
        NoInternet(1),
        ExpiredSession(2),
        TimeOut(4),
        Server(5)
    }
}
