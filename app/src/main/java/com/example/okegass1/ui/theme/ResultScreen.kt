package com.example.okegass1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(input: SimulasiInput, onBack: () -> Unit) {
    val formatter = NumberFormat.getCurrencyInstance(Locale("in", "ID"))

    val penginapanRate = when (input.preferensiPenginapan.lowercase()) {
        "hostel" -> 100_000
        "guest house" -> 200_000
        else -> 300_000
    }

    val makanRate = when (input.gayaHidup.lowercase()) {
        "hemat" -> 40_000
        "standar" -> 80_000
        else -> 150_000
    }

    val transport = 100_000 * input.jumlahOrang
    val akomodasi = penginapanRate * input.durasiHari * input.jumlahOrang
    val makan = makanRate * input.durasiHari * input.jumlahOrang
    val total = akomodasi + makan + transport
    val danaCukup = input.nominal >= total

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hasil Simulasi") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF20B2AA))
                .padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .padding(30.dp)
            ) {
                Column {
                    ResultTextField("Tujuan", input.kotaTujuan)
                    ResultTextField("Dana", formatter.format(input.nominal))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        ResultTextField(
                            "Durasi",
                            "${input.durasiHari} Hari",
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        ResultTextField(
                            "Orang",
                            "${input.jumlahOrang}",
                            modifier = Modifier.weight(1f)
                        )
                    }

                    ResultTextField("Akomodasi", formatter.format(akomodasi))
                    ResultTextField("Makan", formatter.format(makan))
                    ResultTextField("Transport", formatter.format(transport))
                    ResultTextField("Total Estimasi", formatter.format(total))

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (danaCukup) Color(0xFF20B2AA) else Color.Red
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = if (danaCukup) "Dana Cukup" else "Dana Tidak Cukup",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ResultTextField(label: String, value: String, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { Text(label) },
        readOnly = true,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White
        )
    )
}

