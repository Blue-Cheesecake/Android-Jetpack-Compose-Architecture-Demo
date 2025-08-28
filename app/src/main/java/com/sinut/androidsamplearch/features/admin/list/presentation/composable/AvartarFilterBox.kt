import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.ui.theme.onPrimaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryLight
import com.sinut.core_data.api.avartar.constants.AvartarStatus
import com.sinut.core_data.common.interfaces.CommonLabelItem

@Composable
fun <T : CommonLabelItem> AvartarFilterBox(
    label: String,
    items: List<T>,
    selectedItems: List<T>,
    onAddItem: (T) -> Unit,
    onRemoveItem: (T) -> Unit,
) {
    val isSelected = selectedItems.isNotEmpty()

    Box(
        Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(if (selectedItems.isEmpty()) primaryContainerLight else onPrimaryContainerLight)
            .border(
                width = if (!isSelected) 1.dp else 0.dp,
                color = if (!isSelected) Color.Black else Color.Transparent,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .width(120.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (isSelected) {
                Box(
                    Modifier
                        .clip(CircleShape)
                        .background(color = primaryLight)
                        .width(24.dp)
                        .height(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(selectedItems.size.toString(), fontSize = 16.sp, color = Color.White)
                }
                Spacer(Modifier.width(6.dp))
            }
            Text(label, fontSize = 16.sp, color = if (isSelected) Color.White else Color.Black)
        }
    }
}

@Preview(name = "Idle", showBackground = true)
@Composable
private fun AvartarFilterBoxOnIdlePreview() {
    Box(
        Modifier.padding(8.dp)
    ) {
        AvartarFilterBox(
            label = "Status",
            items = AvartarStatus.entries,
            selectedItems = emptyList(),
            onAddItem = {},
            onRemoveItem = {},
        )
    }
}

@Preview(name = "On Selected", showBackground = true)
@Composable
private fun AvartarFilterBoxOnSelectedPreview() {
    Box(
        Modifier.padding(8.dp)
    ) {
        AvartarFilterBox(
            label = "Status",
            items = AvartarStatus.entries,
            selectedItems = listOf(AvartarStatus.COUPLE, AvartarStatus.SINGLE),
            onAddItem = {},
            onRemoveItem = {},
        )
    }
}