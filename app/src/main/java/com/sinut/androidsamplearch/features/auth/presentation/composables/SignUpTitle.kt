package com.sinut.androidsamplearch.features.auth.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.features.auth.constants.AuthMessage
import com.sinut.androidsamplearch.ui.theme.onSecondaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryLight

@Composable
fun SignUpTitle(onClickSignUp: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            AuthMessage.NO_ACCOUNT_TITLE,
            style = TextStyle(
                fontSize = 16.sp,
                color = onSecondaryContainerLight,
            ),
        )
        TextButton(onClick = onClickSignUp) {
            Text(
                AuthMessage.SIGNUP_BUTTON_TITLE,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryLight,
                ),
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpTitlePreview() {
    SignUpTitle {  }
}