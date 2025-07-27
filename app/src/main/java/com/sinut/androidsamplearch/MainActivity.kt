package com.sinut.androidsamplearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sinut.androidsamplearch.core.router.AppNavHost
import com.sinut.androidsamplearch.ui.theme.AndroidSampleArchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSampleArchTheme {
                AppNavHost()
            }
        }
    }
}
