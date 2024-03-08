package mx.com.atriz.ui.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.readable(): String{
    return SimpleDateFormat("yyyy", Locale.getDefault()).format(this)
}