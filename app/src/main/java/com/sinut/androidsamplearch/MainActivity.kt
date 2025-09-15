package com.sinut.androidsamplearch

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.sinut.androidsamplearch.core.router.AppNavHost
import com.sinut.androidsamplearch.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDefaultLocaleOnEmpty()

        val currentLocale = AppCompatDelegate.getApplicationLocales().toLanguageTags()

        enableEdgeToEdge()
        setContent {
            AppTheme(currentLocale = currentLocale) {
                AppNavHost()
            }
        }
    }

    private fun setDefaultLocaleOnEmpty() {
        if (AppCompatDelegate.getApplicationLocales().isEmpty) {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("en"))
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.TIRAMISU) {
            println(newConfig.locales)
            recreate()
        }
    }
}
