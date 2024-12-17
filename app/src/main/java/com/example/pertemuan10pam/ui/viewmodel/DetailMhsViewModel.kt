package com.example.pertemuan10pam.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pertemuan10.viewmodel.MahasiswaEvent
import com.example.pertemuan10pam.data.entity.Mahasiswa
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

//Data class untuk menampung data yang akan di tampilkan di UI

// Memindahkan data dari entity ke ui

fun Mahasiswa.toDetailUiEvent(): MahasiswaEvent{
    return MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}