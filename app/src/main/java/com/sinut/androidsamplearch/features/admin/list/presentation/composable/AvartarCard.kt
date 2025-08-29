package com.sinut.androidsamplearch.features.admin.list.presentation.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sinut.androidsamplearch.common.composables.CommonNetworkImage
import com.sinut.core_data.api.avartar.constants.AvartarStatus
import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel

@Composable
fun AvartarCard(data: AvartarInfoModel) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        CommonNetworkImage(
            imageUrl = data.imageUrl,
            size = Size(44F, 44F)
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(data.fullName, fontWeight = FontWeight.Medium, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Text(data.status.label, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview(name = "Default", showBackground = true)
@Composable
private fun AvartarCardDefaultPreview() {
    Box(
        Modifier
            .padding(12.dp)
            .border(1.dp, SolidColor(Color.Black), RoundedCornerShape(0.dp))
    ) {
        AvartarCard(
            AvartarInfoModel(
                id = "123",
                fullName = "Hello World",
                status = AvartarStatus.SINGLE,
                imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQpflckqTzo_CVJxHUPahKCrnIL3d2DIJn1ThfaalZfK682pUAn3mFidzfZM_yuLhNwHlLHRd_UkAVb_KZQfj4pnA"
            )
        )
    }
}