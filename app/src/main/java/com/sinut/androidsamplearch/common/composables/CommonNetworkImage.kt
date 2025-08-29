package com.sinut.androidsamplearch.common.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ImageNotSupported
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter

@Composable
fun CommonNetworkImage(imageUrl: String, size: Size, shape: Shape = CircleShape) {
    val painter = rememberAsyncImagePainter(imageUrl)
    val state = painter.state.collectAsStateWithLifecycle()

    Box(
        Modifier
            .clip(shape)
            .width(size.width.dp)
            .height(size.height.dp)
            .background(Color.Gray.copy(alpha = 0.4F)),
        contentAlignment = Alignment.Center
    ) {
        when (state.value) {
            is AsyncImagePainter.State.Empty,
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator()
            }

            is AsyncImagePainter.State.Success -> {
                Image(painter = painter, contentDescription = null)
            }

            is AsyncImagePainter.State.Error -> {
                Icon(
                    Icons.Filled.ImageNotSupported, contentDescription = null,
                    modifier = Modifier
                        .width(12.dp)
                        .height(12.dp)
                )
            }
        }
    }
}

@Preview(name = "Default", showBackground = true)
@Composable
private fun CommonNetworkImageDefaultPreview() {
    Box(Modifier.padding(12.dp)) {
        CommonNetworkImage(
            imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQpflckqTzo_CVJxHUPahKCrnIL3d2DIJn1ThfaalZfK682pUAn3mFidzfZM_yuLhNwHlLHRd_UkAVb_KZQfj4pnA",
            size = Size(50F, 50F),
        )
    }
}