package com.sinut.androidsamplearch.features.admin.list.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.details.data.models.AdminDetailsModel
import com.sinut.androidsamplearch.features.admin.details.presentation.models.AdminDetailsScreenArgs
import com.sinut.androidsamplearch.features.admin.list.constants.AvartarListMessages
import com.sinut.androidsamplearch.features.admin.list.presentation.composable.SearchAvartarTextField
import com.sinut.androidsamplearch.features.admin.list.presentation.logic.api.avartar.AvartarsListApiViewModel
import com.sinut.androidsamplearch.features.admin.list.presentation.logic.input.AvartarFilterInputViewModel
import com.sinut.androidsamplearch.ui.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminListScreen(
    navActions: AdminNavActions,
    avartarListviewModel: AvartarsListApiViewModel = hiltViewModel(),
    avartarFilterInputViewModel: AvartarFilterInputViewModel = viewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        AvartarListMessages.APP_BAR_TITLE, style = LocalTextStyle.current.copy(
                            fontSize = AppTypography.titleSmall.fontSize
                        )
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
           Box(Modifier.padding(horizontal = 8.dp)) {
               val searchText = avartarFilterInputViewModel.uiState.collectAsStateWithLifecycle().value.searchText

               SearchAvartarTextField(
                   value = searchText,
                   onValueChanged = { avartarFilterInputViewModel.updateSearchText(it) }
               )
           }
        }
    }
}