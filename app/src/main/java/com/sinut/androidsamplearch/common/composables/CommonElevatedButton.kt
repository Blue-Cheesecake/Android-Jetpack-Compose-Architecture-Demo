package com.sinut.androidsamplearch.common.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.common.constants.CommonButtonSize
import com.sinut.androidsamplearch.ui.theme.onPrimaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryContainerLight

@Composable
fun CommonElevatedButton(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle? = null,
    onClick: () -> Unit,
    size: CommonButtonSize = CommonButtonSize.MEDIUM,
) {
    ElevatedButton(
        modifier = modifier
            .height(size.height.dp),
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors()
            .copy(containerColor = onPrimaryContainerLight),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(
            text, style = textStyle ?: TextStyle(
                color = primaryContainerLight,
                fontSize = when (size) {
                    CommonButtonSize.MEDIUM -> 16.sp
                    CommonButtonSize.LARGE -> 18.sp
                },
                fontWeight = FontWeight.Medium,
            )
        )
    }
}

@Preview(name = "Default", showBackground = true)
@Composable
private fun CommonElevatedButtonDefaultPreview() {
    Box(Modifier.padding(12.dp)) {
        CommonElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            text = "My Button",
            onClick = {},
        )
    }
}

@Preview(name = "Large", showBackground = true)
@Composable
private fun CommonElevatedButtonLargePreview() {
    Box(Modifier.padding(12.dp)) {
        CommonElevatedButton(
            modifier = Modifier.fillMaxWidth(),
            text = "My Button",
            onClick = {},
            size = CommonButtonSize.LARGE,
        )
    }
}
