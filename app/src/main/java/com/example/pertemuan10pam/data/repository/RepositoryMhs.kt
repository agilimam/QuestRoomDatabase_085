package com.example.pertemuan10pam.data.repository

import com.example.pertemuan10pam.data.entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}