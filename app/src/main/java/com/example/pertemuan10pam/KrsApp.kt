package com.example.pertemuan10pam

import android.app.Application
import com.example.pertemuan10pam.dependenciesinjection.ContainerApp
import com.example.pertemuan10pam.dependenciesinjection.InterfaceContainerApp

class KrsApp : Application(){
    //Fungsinya untuk menyimpan instance containerapp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //Membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //Instance adalah object yang di buat dari class
    }
}