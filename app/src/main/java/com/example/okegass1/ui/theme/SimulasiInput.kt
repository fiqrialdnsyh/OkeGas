package com.example.okegass1.ui.theme

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimulasiInput(
    val kotaTujuan: String,
    val nominal: Int,
    val durasiHari: Int,
    val jumlahOrang: Int,
    val preferensiPenginapan: String,
    val gayaHidup: String
) : Parcelable

