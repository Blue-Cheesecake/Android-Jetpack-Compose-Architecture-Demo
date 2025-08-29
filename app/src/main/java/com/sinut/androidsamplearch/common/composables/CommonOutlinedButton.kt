import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.common.constants.CommonButtonSize

@Composable
fun CommonOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    tetStyle: TextStyle? = null,
    onClick: () -> Unit,
    size: CommonButtonSize = CommonButtonSize.MEDIUM
) {
    OutlinedButton(
        modifier = modifier
            .height(size.height.dp),
        onClick = onClick,
        colors = ButtonDefaults.elevatedButtonColors()
            .copy(containerColor = Color.White),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(4.dp),
    ) {
        Text(
            text = text, style = tetStyle ?: TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = when (size) {
                    CommonButtonSize.MEDIUM -> 16.sp
                    CommonButtonSize.LARGE -> 18.sp
                }
            )
        )
    }
}

@Preview(name = "Default", showBackground = true)
@Composable
private fun CommonOutlinedButtonDefaultPreview() {
    Box(Modifier.padding(12.dp)) {
        CommonOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            text = "My Outline",
            onClick = {})
    }
}

@Preview(name = "Large", showBackground = true)
@Composable
private fun CommonOutlinedButtonLargePreview() {
    Box(Modifier.padding(12.dp)) {
        CommonOutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            text = "My Outline",
            onClick = {},
            size = CommonButtonSize.LARGE,
        )
    }
}