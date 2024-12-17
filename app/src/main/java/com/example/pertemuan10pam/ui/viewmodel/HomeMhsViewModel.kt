package com.example.pertemuan10pam.ui.viewmodel


import com.example.pertemuan10pam.data.entity.Mahasiswa


data class HomeUiState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)


