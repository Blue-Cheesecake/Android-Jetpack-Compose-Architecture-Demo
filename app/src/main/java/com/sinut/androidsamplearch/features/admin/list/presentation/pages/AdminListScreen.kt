package com.sinut.androidsamplearch.features.admin.list.presentation.pages

import AvartarFilterBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sinut.androidsamplearch.features.admin.core.router.AdminNavActions
import com.sinut.androidsamplearch.features.admin.list.constants.AvartarListMessages
import com.sinut.androidsamplearch.features.admin.list.presentation.composable.SearchAvartarTextField
import com.sinut.androidsamplearch.features.admin.list.presentation.logic.api.avartar.AvartarsListApiViewModel
import com.sinut.androidsamplearch.features.admin.list.presentation.logic.input.AvartarFilterInputViewModel
import com.sinut.core_data.api.avartar.constants.AvartarPet
import com.sinut.core_data.api.avartar.constants.AvartarStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminListScreen(
    navActions: AdminNavActions,
    avartarListviewModel: AvartarsListApiViewModel = hiltViewModel(),
    avartarFilterInputViewModel: AvartarFilterInputViewModel = viewModel(),
) {
    val localFocusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier
            .clickable {
                localFocusManager.clearFocus()
            },
        topBar = {
            TopAppBar(
                title = {
                    Text(AvartarListMessages.APP_BAR_TITLE, fontSize = 24.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.White)
            )
        },
        containerColor = Color.White,
    ) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(Modifier.padding(horizontal = 18.dp)) {
                Column {
                    val searchText = avartarFilterInputViewModel.uiState.collectAsStateWithLifecycle().value.searchText

                    SearchAvartarTextField(
                        value = searchText,
                        onValueChanged = { avartarFilterInputViewModel.updateSearchText(it) }
                    )
                    Spacer(Modifier.height(18.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        item {
                            val inputState = avartarFilterInputViewModel.uiState.collectAsStateWithLifecycle()

                            AvartarFilterBox(
                                label = AvartarListMessages.STATUS_FILTER_LABEL,
                                items = AvartarStatus.entries,
                                selectedItems = inputState.value.status,
                                tempSelectedItems = inputState.value.tempStatus,
                                onInitialBottomSheet = { avartarFilterInputViewModel.onInitialStatus() },
                                onAddItem = { avartarFilterInputViewModel.onAddStatus(it) },
                                onRemoveItem = { avartarFilterInputViewModel.onRemoveStatus(it) },
                                onApply = { avartarFilterInputViewModel.onApplyStatus() },
                                onCancel = { avartarFilterInputViewModel.onCancelStatus() },
                            )
                        }
                        item {
                            val inputState = avartarFilterInputViewModel.uiState.collectAsStateWithLifecycle()

                            AvartarFilterBox(
                                label = AvartarListMessages.PETS_FILTER_LABEL,
                                items = AvartarPet.entries,
                                selectedItems = inputState.value.pets,
                                tempSelectedItems = inputState.value.tempPets,
                                onInitialBottomSheet = { avartarFilterInputViewModel.onInitialPet() },
                                onAddItem = { avartarFilterInputViewModel.onAddPet(it) },
                                onRemoveItem = { avartarFilterInputViewModel.onRemovePet(it) },
                                onApply = { avartarFilterInputViewModel.onApplyPet() },
                                onCancel = { avartarFilterInputViewModel.onCancelPet() },
                            )
                        }
                    }
                }
            }
        }
    }
}