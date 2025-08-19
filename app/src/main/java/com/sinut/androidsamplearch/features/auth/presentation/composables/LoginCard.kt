package com.sinut.androidsamplearch.features.auth.presentation.composables

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sinut.androidsamplearch.features.auth.constants.AuthMessage
import com.sinut.androidsamplearch.features.auth.presentation.logic.input.LoginInputState
import com.sinut.androidsamplearch.features.auth.presentation.logic.input.LoginInputViewModel
import com.sinut.androidsamplearch.features.auth.presentation.logic.validation.LoginValidationViewModel
import com.sinut.androidsamplearch.ui.theme.onSecondaryLight
import com.sinut.androidsamplearch.ui.theme.onSurfaceVariantLight
import com.sinut.androidsamplearch.ui.theme.primaryLight

@Composable
fun LoginCard(
    onClickSignIn: () -> Unit,
    onFormValid: (input: LoginInputState) -> Unit,
    loginInputViewModel: LoginInputViewModel = viewModel(),
    loginValidationViewModel: LoginValidationViewModel = viewModel(),
) {

    Column(
        modifier = Modifier
            .shadow(5.dp)
            .background(onSecondaryLight, shape = RoundedCornerShape(8.dp))
            .padding(20.dp)
        ,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            AuthMessage.CARD_TITLE,
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = onSurfaceVariantLight,
            ),
        )

        Spacer(Modifier.height(24.dp))
        LoginFormFields(loginInputViewModel, loginValidationViewModel)
        Spacer(Modifier.height(24.dp))
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = {
                onClickSignIn()

                val input = loginInputViewModel.uiState.value
                val isFormValid = loginValidationViewModel.validate(loginInputViewModel.uiState.value)

                if (isFormValid) {
                    onFormValid(input)
                }
            },
            shape = RoundedCornerShape(8),
            colors = ButtonDefaults.elevatedButtonColors().copy(
                containerColor = primaryLight
            ),
            elevation = null,
        ) {
            Text(
                AuthMessage.SIGNIN_BUTTON_TITLE, style = TextStyle(
                    fontSize = 16.sp,
                    color = onSecondaryLight
                )
            )
        }
    }
}

@Preview(backgroundColor = Color.GRAY.toLong(), showBackground = true)
@Composable
private fun LoginCardPreview() {

    LoginCard(
        onClickSignIn = {},
        onFormValid = {}
    )
}