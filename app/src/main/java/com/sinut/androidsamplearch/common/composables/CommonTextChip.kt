import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.ui.theme.inversePrimaryLight
import com.sinut.androidsamplearch.ui.theme.onPrimaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryContainerLight
import com.sinut.androidsamplearch.ui.theme.surfaceLight

@Composable
fun CommonTextChip(
    text: String,
    style: TextStyle? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Box(
        Modifier
            .clip(CircleShape)
            .background(if (!isSelected) Color.Gray.copy(alpha = 0.2f) else primaryContainerLight)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text,
            style = style ?: TextStyle(
                fontSize = 14.sp,
                color = if (!isSelected) Color.Gray else onPrimaryContainerLight
            )
        )
    }
}

@Preview(name = "Idle", showBackground = true)
@Composable
private fun CommonTextChipIdlePreview() {
    Box(Modifier.padding(16.dp)) {
        CommonTextChip(
            text = "Seagull in the sea",
            onClick = {}
        )
    }
}

@Preview(name = "Selected", showBackground = true)
@Composable
private fun CommonTextChipSelectedPreview() {
    Box(Modifier.padding(16.dp)) {
        CommonTextChip(
            text = "Seagull in the sea",
            isSelected = true,
            onClick = {}
        )
    }
}