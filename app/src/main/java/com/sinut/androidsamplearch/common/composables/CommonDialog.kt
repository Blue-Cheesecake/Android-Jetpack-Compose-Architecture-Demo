package com.sinut.androidsamplearch.common.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CommonDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String? = null,
    icon: @Composable (() -> Unit)? = null,
) {
    AlertDialog(
        icon = icon,
        title = {
            Text(text = dialogTitle, style = TextStyle(fontSize = 24.sp))
        },
        text = {
            if (dialogText != null) {
                Text(text = dialogText, style = TextStyle(fontSize = 16.sp))
            }
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Preview
@Composable
private fun CommonDialogPreview() {

}