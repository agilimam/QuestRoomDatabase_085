package com.example.pertemuan10pam.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pertemuan10.viewmodel.MahasiswaViewModel

import com.example.pertemuan10pam.KrsApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            MahasiswaViewModel(
                krsApp().containerApp.repositoryMhs
            )
        }
    }
}
fun CreationExtras.krsApp():KrsApp=
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)