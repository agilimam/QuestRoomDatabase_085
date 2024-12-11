package com.example.pertemuan10pam.dependenciesinjection

import android.content.Context
import com.example.pertemuan10pam.data.database.KrsDatabase
import com.example.pertemuan10pam.data.repository.LocalRepositoryMhs
import com.example.pertemuan10pam.data.repository.RepositoryMhs

interface InterfaceContainerApp{
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context):InterfaceContainerApp{
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}