package mx.com.atriz.ui.interfaces

import androidx.annotation.IdRes
import androidx.navigation.NavDirections

interface AppInterface {

    fun goTo(@IdRes fragment: Int) {}

    fun goTo(options: NavDirections) {}
}