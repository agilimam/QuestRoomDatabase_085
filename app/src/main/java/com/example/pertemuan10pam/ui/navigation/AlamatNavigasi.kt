package com.example.pertemuan10pam.ui.navigation

interface AlamatNavigasi {
    val route : String
}

object DestinationHome : AlamatNavigasi{
    override val route = "home"
}

object DestinasiDetail : AlamatNavigasi{
    override val route = "detail"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
}

object DestinasiUpdate : AlamatNavigasi {
    override val route = "update"
    const val NIM ="nim"
    val routesWithArg = "$route/{$NIM}"
}