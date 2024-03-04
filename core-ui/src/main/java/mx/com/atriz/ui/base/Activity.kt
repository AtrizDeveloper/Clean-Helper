package mx.com.atriz.ui.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class Activity<viewBinding : ViewBinding> : AppCompatActivity() {
    private var _binding: viewBinding? = null
    val binding get() = _binding!!
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
        setContentView(binding.root)
        updateUiMode(resources.configuration)
        setUpNavigation()?.let { navigation ->
            with(supportFragmentManager.findFragmentById(navigation)) {
                (this as NavHostFragment).findNavController().let {
                    this@Activity.navController = it
                }
            }
        }
        onCreation(savedInstanceState)
        setUpViewListeners()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED, stateMachinery())
        }
    }


    abstract fun getViewBinding(): viewBinding

    open fun setUpNavigation(): Int? = null

    open fun onCreation(savedInstanceState: Bundle?) {}

    open fun setUpViewListeners() {}

    open fun setupObservers() {}

    open suspend fun stateMachinery(): suspend CoroutineScope.() -> Unit = {}
    private fun updateUiMode(configuration: Configuration) {
        when (configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> AppCompatDelegate.MODE_NIGHT_NO
            Configuration.UI_MODE_NIGHT_YES -> AppCompatDelegate.MODE_NIGHT_YES
        }
    }
}