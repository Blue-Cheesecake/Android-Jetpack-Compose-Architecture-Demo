package com.sinut.androidsamplearch.features.auth.presentation.pages

import android.annotation.SuppressLint
import android.provider.Settings
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sinut.androidsamplearch.R
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginEventListener
import com.sinut.androidsamplearch.features.auth.presentation.composables.SignUpTitle
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.EnableBioAuthState
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginViewModel

@SuppressLint("HardwareIds")
@Composable
fun LoginScreen(
    navActions: AdminNavActions,
    loginApiViewModel: LoginViewModel = hiltViewModel(),
) {
    val localFocusManager = LocalFocusManager.current
    LocalContext.current

    LaunchedEffect(Unit) {
        println("Screen1 launched")
    }

    LoginEventListener(navActions, loginApiViewModel) {
        val loginUiState = loginApiViewModel.uiState.collectAsStateWithLifecycle()
        val context = LocalContext.current

        Scaffold { innerPadding ->
            Image(
                painter = painterResource(R.drawable.landing_background),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize(),
            )

            Column(
                Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            localFocusManager.clearFocus()
                        })
                    }
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(Modifier.weight(0.5F))
//                Box(Modifier.padding(horizontal = 20.dp)) {
//                    LoginCard(
//                        onClickSignIn = {
//                            localFocusManager.clearFocus()
//                        }, onFormValid = {
//                            loginApiViewModel.login(it.username, it.password)
//                        }
//                    )
//                }
                Spacer(Modifier.height(24.dp))
                Button({
                    println(LocaleListCompat.getDefault())
                    println(LocaleListCompat.getEmptyLocaleList())
                    println(LocaleListCompat.forLanguageTags("en"))
                    println(LocaleListCompat.forLanguageTags("th"))
                    println(AppCompatDelegate.getApplicationLocales())
                    println(
                        "Default: ${
                            AppCompatDelegate.getApplicationLocales().toLanguageTags()
                        }"
                    )
                }) {
                    Text(stringResource(R.string.list_language))
                }
                Spacer(Modifier.height(8.dp))
                Button({
                    val currentLang = AppCompatDelegate.getApplicationLocales()

                    if (currentLang.toLanguageTags() == "en") {
                        AppCompatDelegate.setApplicationLocales(
                            LocaleListCompat.forLanguageTags(
                                "th"
                            )
                        )
                    } else {
                        AppCompatDelegate.setApplicationLocales(
                            LocaleListCompat.forLanguageTags(
                                "en"
                            )
                        )
                    }

                    println("Current: ${AppCompatDelegate.getApplicationLocales()}")
                }) {
                    Text(stringResource(R.string.change_language))
                }
                Spacer(Modifier.height(8.dp))
                Button({
                    println(
                        Settings.Secure.getString(
                            context.contentResolver, Settings.Secure.ANDROID_ID
                        )
                    )
                }) {
                    Text("Log ANDROID_ID")
                }
                Button({
                    loginApiViewModel.enableBiometric()
                }) {
                    Text("Enable Biometric Auth")
                }

                when (loginUiState.value.enableBioAuthState) {
                    is EnableBioAuthState.Idle -> {
                        Box {}
                    }

                    is EnableBioAuthState.Loading -> {
                        CircularProgressIndicator()
                    }

                    is EnableBioAuthState.Success -> {
                        val response =
                            loginUiState.value.enableBioAuthState as EnableBioAuthState.Success
                        Text("Biometric auth enabled successfully")
                        Text("biometric id ${response.result.result.biometricId}")
                    }

                    is EnableBioAuthState.Error -> {
                        Text("Failed to enable biometric auth")
                    }
                }

                Spacer(Modifier.height(8.dp))
                Button({
                    navActions.goToAdminList()
                }) {
                    Text("Go to next page")
                }
                Spacer(Modifier.weight(1F))
                SignUpTitle(onClickSignUp = {})
                Spacer(Modifier.height(24.dp))
            }
        }
    }
}
