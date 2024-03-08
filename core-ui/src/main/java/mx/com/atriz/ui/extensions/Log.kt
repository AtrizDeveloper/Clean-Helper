package mx.com.atriz.ui.extensions

import android.util.Log
import java.lang.Exception


fun l(message: String) {
    Log.e("Atriz", message)
}

fun l(message: String, exception: Exception) {
    Log.e("Atriz", message, exception)
}