package com.example.pertemuan10pam.data.repository

import com.example.pertemuan10pam.data.dao.MahasiswaDao
import com.example.pertemuan10pam.data.entity.Mahasiswa

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs{
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }

}