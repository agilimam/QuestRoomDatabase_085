package com.example.pertemuan10pam.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pertemuan10pam.data.dao.MahasiswaDao
import com.example.pertemuan10pam.data.entity.Mahasiswa

//Mendifinisikan database  dengan tabel mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false )
abstract class KrsDatabase : RoomDatabase(){

    //Mendifinisakn fungsi untuk mengakses data mahasiswa

    abstract fun mahasiswaDao() : MahasiswaDao

    companion object{
        @Volatile  //Memastikan bahwa nilai variabel instance selali salu sama di semua thread
        private var Instance:KrsDatabase? = null

        fun getDatabase(context: Context):KrsDatabase{
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //class database
                    "krsDatabase" // nama database
                )
                    .build().also { Instance = it }
            })
        }
    }
}