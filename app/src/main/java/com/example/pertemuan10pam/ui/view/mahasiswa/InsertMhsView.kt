package com.example.pertemuan10pam.ui.view.mahasiswa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan10.viewmodel.FormErrorState
import com.example.pertemuan10.viewmodel.MahasiswaEvent
import com.example.pertemuan10.viewmodel.MahasiswaViewModel
import com.example.pertemuan10.viewmodel.MhsUIState
import com.example.pertemuan10pam.ui.costumwidget.TopAppBar
import com.example.pertemuan10pam.ui.navigation.AlamatNavigasi
import com.example.pertemuan10pam.ui.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

object DestinasiInsert: AlamatNavigasi{
    override val route: String = "inset_mhs"
}
@Preview(showBackground = true)
@Composable
fun  FormMahasiswa(
    mahasiswaEvent: MahasiswaEvent = MahasiswaEvent(),
    onvalueChange: (MahasiswaEvent)-> Unit = {},
    errorState:FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
){
    val jenisKelamin = listOf("Laki laki","Perempuan")
    val kelas = listOf("A","B","C","D","E")

    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nama,
            onValueChange = {
                onvalueChange(mahasiswaEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.nama  != null,
            placeholder = { Text("Masukkan Nama") }
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.nim,
            onValueChange = {
                onvalueChange(mahasiswaEvent.copy(nim = it))
            },
            label = { Text("Nim") },
            isError = errorState.nim  != null,
            placeholder = { Text("Masukkan Nim") }
        )
        Text(
            text = errorState.nim ?: "",
            color = Color.Red
        )
        Spacer(modifier =Modifier.height(10.dp))
        Text(text = "Jenis Kelamin")
        Row (modifier = Modifier.fillMaxWidth()){
            jenisKelamin.forEach { jk ->
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    RadioButton(
                        selected = mahasiswaEvent.jenisKelamin == jk,
                        onClick = {
                            onvalueChange(mahasiswaEvent.copy(jenisKelamin = jk))
                        },
                    )
                    Text(
                        text = jk,
                    )
                }
            }
        }
        Text(
            text = errorState.jeniskelamin?:"",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.alamat,
            onValueChange = {
                onvalueChange(mahasiswaEvent.copy(alamat = it))
            },
            label = { Text("Alamat") },
            isError = errorState.nim  != null,
            placeholder = { Text("Masukkan Alamat") }
        )
        Text(
            text = errorState.alamat ?: "",
            color = Color.Red
        )

        Spacer(modifier =Modifier.height(10.dp))
        Text(text = "Kelas")
        Row (modifier = Modifier.fillMaxWidth()){
            kelas.forEach { Kelas ->
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    RadioButton(
                        selected = mahasiswaEvent.kelas == Kelas,
                        onClick = {
                            onvalueChange(mahasiswaEvent.copy(kelas = Kelas))
                        },
                    )
                    Text(
                        text = Kelas,
                    )
            }
        }

        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mahasiswaEvent.angkatan,
            onValueChange = {
                onvalueChange(mahasiswaEvent.copy(angkatan = it))
            },
            label = { Text("Angktan") },

            isError = errorState.nim  != null,
            placeholder = { Text("Masukkan Angkatan") }
        )
        Text(
            text = errorState.angkatan ?: "",
            color = Color.Red
        )
    }
}

@Composable
fun InsertMhsView(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    viewModel: MahasiswaViewModel = viewModel(factory = PenyediaViewModel.Factory) //Inisialisasi ViewModel
) {
    val uiState = viewModel.uiState // Ambil UI State dari viewmodel
    val snackbarHostState =  remember { SnackbarHostState() } // Snack
    val coroutineScope = rememberCoroutineScope()

    // Observasi perubahan snackBarMessage
    LaunchedEffect(uiState.snackBarMessage)  {
        uiState.snackBarMessage?.let { message ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetSnackBarMessage()
            }
        }
    }

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)}
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Mahasiswa",
            )

            //Isi Body
            InsertBodyMhs(
                uiState = uiState,
                onvalueChange = { updateEvent ->
                    //Update state di viewmodel
                    viewModel.updateState(updateEvent)
                },
                onClick = {
                    viewModel.saveData()
                    onNavigate()
                }
            )

        }

    }
}
@Composable
fun InsertBodyMhs(
    modifier: Modifier = Modifier,
    onvalueChange: (MahasiswaEvent) -> Unit,
    uiState: MhsUIState,
    onClick: () -> Unit
){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        FormMahasiswa(
            mahasiswaEvent = uiState.mahasiswaEvent,
            onvalueChange = onvalueChange,
            errorState = uiState.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Simpan")
        }

    }
}