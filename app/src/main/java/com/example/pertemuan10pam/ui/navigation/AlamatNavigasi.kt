package com.example.pertemuan10pam.ui.navigation

interface AlamatNavigasi {
    val route : String
}

object DestinationHome : AlamatNavigasi{
    override val route = "home"
}
