package com.sinut.androidsamplearch.features.admin.list.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sinut.androidsamplearch.features.admin.list.constants.AvartarListMessages

@Composable
fun SearchAvartarTextField(value: String?, onValueChanged: (String?) -> Unit) {
    OutlinedTextField(
        value = value ?: "",
        onValueChange = onValueChanged,
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier.size(22.dp),
            )
        },
        placeholder = {
            Text(
                AvartarListMessages.SEARCH_PLACE_HOLDER, style = TextStyle(
                    fontSize = 14.sp
                )
            )
        },
        textStyle = TextStyle(fontSize = 14.sp),
        singleLine = true,
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
    )
}

@Preview(name = "Empty", showBackground = true)
@Composable
private fun SearchAvartarTextFieldOnEmptyPreview() {
    Box(modifier = Modifier.padding(8.dp)) {
        SearchAvartarTextField(
            value = null,
            onValueChanged = {}
        )
    }
}

@Preview(name = "On Text", showBackground = true)
@Composable
private fun SearchAvartarTextFieldOnTextPreview() {
    Box(modifier = Modifier.padding(8.dp)) {
        SearchAvartarTextField(
            value = "hello world eiei",
            onValueChanged = {}
        )
    }
}