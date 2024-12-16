package com.example.pertemuan10pam.data.repository

import androidx.room.Update
import com.example.pertemuan10pam.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)

    fun getAllMhs(): Flow<List<Mahasiswa>>
    fun getMhs(nim: String): Flow<Mahasiswa>
    suspend fun deleteMhs(mahasiswa: Mahasiswa)
    suspend fun UpdateMhs(mahasiswa: Mahasiswa)
}