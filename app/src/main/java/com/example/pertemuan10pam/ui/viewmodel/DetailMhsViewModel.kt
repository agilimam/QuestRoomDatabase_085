package com.example.pertemuan10pam.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pertemuan10.viewmodel.MahasiswaEvent
import com.example.pertemuan10pam.data.repository.RepositoryMhs
import com.example.pertemuan10pam.ui.navigation.DestinasiDetail
import kotlinx.coroutines.flow.StateFlow



data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""

) {
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MahasiswaEvent()
    val isUiEvenNotEmpty: Boolean
        get() = detailUiEvent != MahasiswaEvent()
}
