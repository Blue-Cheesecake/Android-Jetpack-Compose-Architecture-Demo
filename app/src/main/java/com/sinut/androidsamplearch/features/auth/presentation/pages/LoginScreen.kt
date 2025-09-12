package com.sinut.androidsamplearch.features.auth.presentation.pages

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.sinut.androidsamplearch.R
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginCard
import com.sinut.androidsamplearch.features.auth.presentation.composables.LoginEventListener
import com.sinut.androidsamplearch.features.auth.presentation.composables.SignUpTitle
import com.sinut.androidsamplearch.features.auth.presentation.logic.api.LoginApiViewModel

@Composable
fun LoginScreen(
    navActions: AdminNavActions,
    loginApiViewModel: LoginApiViewModel = hiltViewModel(),
) {
    val localFocusManager = LocalFocusManager.current

    LoginEventListener(navActions, loginApiViewModel) {
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
                Box(Modifier.padding(horizontal = 20.dp)) {
                    LoginCard(
                        onClickSignIn = {
                            localFocusManager.clearFocus()
                        }, onFormValid = {
                            loginApiViewModel.login(it.username, it.password)
                        }
                    )
                }
                Spacer(Modifier.height(24.dp))
                Button({
                    println(LocaleListCompat.getDefault())
                    println(LocaleListCompat.getEmptyLocaleList())
                    println(LocaleListCompat.forLanguageTags("en"))
                    println(LocaleListCompat.forLanguageTags("th"))
                    println(AppCompatDelegate.getApplicationLocales())
                    println(AppCompatDelegate.getApplicationLocales().toLanguageTags())
                }) {
                    Text("List Languages")
                }
                Spacer(Modifier.height(8.dp))
                Button({
                    val currentLang = AppCompatDelegate.getApplicationLocales()

                    if (currentLang.toLanguageTags() == "en") {
                        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("th"))
                    } else {
                        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("en"))
                    }
                    println("Current: ${AppCompatDelegate.getApplicationLocales()}")
                }) {
                    Text("Change Language")
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
