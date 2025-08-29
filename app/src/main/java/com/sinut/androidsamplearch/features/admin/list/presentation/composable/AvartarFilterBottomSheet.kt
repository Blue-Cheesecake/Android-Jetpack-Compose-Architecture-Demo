import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.common.composables.CommonElevatedButton
import com.sinut.androidsamplearch.common.constants.CommonUiMessages
import com.sinut.core_data.api.avartar.constants.AvartarStatus
import com.sinut.core_data.common.interfaces.CommonLabelItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : CommonLabelItem> AvartarFilterBottomSheet(
    sheetState: SheetState,
    label: String,
    itemsLabel: List<T>,
    selectedItems: List<T>,
    onAddItem: (T) -> Unit,
    onRemoveItem: (T) -> Unit,
    onDismissBottomSheet: () -> Unit,
    onClickApply: () -> Unit,
) {
    ModalBottomSheet(
        modifier = Modifier.fillMaxHeight(),
        sheetState = sheetState,
        onDismissRequest = onDismissBottomSheet,
        containerColor = Color.White,
    ) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            Text(label, fontSize = 24.sp, fontWeight = FontWeight.Medium)
            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                repeat(itemsLabel.size) { index ->
                    val itemLabel = itemsLabel[index]
                    val isThisSelected = selectedItems.contains(itemLabel)

                    CommonTextChip(text = itemLabel.label, isSelected = isThisSelected) {
                        if (isThisSelected) {
                            onRemoveItem(itemLabel)
                        } else {
                            onAddItem(itemLabel)
                        }
                    }
                }
            }
            Spacer(Modifier.weight(0.5F))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CommonOutlinedButton(
                    modifier = Modifier.weight(0.5F),
                    text = CommonUiMessages.CANCEL,
                    onClick = onDismissBottomSheet,
                )
                CommonElevatedButton(
                    modifier = Modifier.weight(0.5F),
                    text = CommonUiMessages.APPLY,
                    onClick = onClickApply,
                )
            }
            Spacer(Modifier.weight(1F))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Idle")
@Composable
private fun AvartarFilterBottomSheetIdlePreview() {
    var selectedItems by remember { mutableStateOf<List<AvartarStatus>>(emptyList()) }
    val sheetState = rememberStandardBottomSheetState(
        skipHiddenState = true,
        confirmValueChange = { false },
    )

    AvartarFilterBottomSheet(
        sheetState = sheetState,
        label = "Status",
        itemsLabel = AvartarStatus.entries,
        selectedItems = selectedItems,
        onAddItem = {
            selectedItems = selectedItems.plus(it)
        },
        onRemoveItem = {
            selectedItems = selectedItems.minus(it)
        },
        onDismissBottomSheet = {},
        onClickApply = {},
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Selected")
@Composable
private fun AvartarFilterBottomSheetSelectedPreview() {
    var selectedItems by remember {
        mutableStateOf<List<AvartarStatus>>(
            listOf(
                AvartarStatus.SINGLE,
                AvartarStatus.COUPLE
            )
        )
    }
    val sheetState = rememberStandardBottomSheetState(
        skipHiddenState = true,
        confirmValueChange = { false },
    )

    AvartarFilterBottomSheet(
        sheetState = sheetState,
        label = "Status",
        itemsLabel = AvartarStatus.entries,
        selectedItems = selectedItems,
        onAddItem = {
            selectedItems = selectedItems.plus(it)
        },
        onRemoveItem = {
            selectedItems = selectedItems.minus(it)
        },
        onDismissBottomSheet = {},
        onClickApply = {},
    )
}