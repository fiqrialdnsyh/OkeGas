package com.example.okegass1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.okegass1.ui.theme.SimulasiInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimulasiScreen(onSimulasiClick: (SimulasiInput) -> Unit, modifier: Modifier = Modifier) {
    var kota by remember { mutableStateOf("") }
    var dana by remember { mutableStateOf("") }
    var durasi by remember { mutableStateOf("") }
    var orang by remember { mutableStateOf("") }

    var penginapan by remember { mutableStateOf("") }
    val penginapanOptions = listOf("Hostel", "Hotel", "Guest House")
    var penginapanExpanded by remember { mutableStateOf(false) }

    var gaya by remember { mutableStateOf("") }
    val gayaOptions = listOf("Hemat", "Standar", "Mewah")
    var gayaExpanded by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color(0xFF20B2AA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Wujudkan Perjalananmu",
            fontSize = 20.sp,
            color = Color.White
        )
        Text(
            text = "dengan Caramu",
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "OkeGASS",
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        // WRAPPER PUTIH
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                OutlinedTextField(
                    value = kota,
                    onValueChange = { kota = it },
                    label = { Text("Masukan Kota Tujuan") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = dana,
                    onValueChange = { dana = it },
                    label = { Text("Masukan Nominal") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = durasi,
                    onValueChange = { durasi = it },
                    label = { Text("Durasi Perjalanan") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = orang,
                    onValueChange = { orang = it },
                    label = { Text("Jumlah Orang") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                ExposedDropdownMenuBox(
                    expanded = penginapanExpanded,
                    onExpandedChange = { penginapanExpanded = !penginapanExpanded }
                ) {
                    OutlinedTextField(
                        value = penginapan,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Preferensi Penginapan") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = penginapanExpanded) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = penginapanExpanded,
                        onDismissRequest = { penginapanExpanded = false }
                    ) {
                        penginapanOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option) },
                                onClick = {
                                    penginapan = option
                                    penginapanExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                ExposedDropdownMenuBox(
                    expanded = gayaExpanded,
                    onExpandedChange = { gayaExpanded = !gayaExpanded }
                ) {
                    OutlinedTextField(
                        value = gaya,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Pengeluaran Harian") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = gayaExpanded) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = gayaExpanded,
                        onDismissRequest = { gayaExpanded = false }
                    ) {
                        gayaOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(option) },
                                onClick = {
                                    gaya = option
                                    gayaExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val input = SimulasiInput(
                    kotaTujuan = kota,
                    nominal = dana.toIntOrNull() ?: 0,
                    durasiHari = durasi.toIntOrNull() ?: 0,
                    jumlahOrang = orang.toIntOrNull() ?: 0,
                    preferensiPenginapan = penginapan,
                    gayaHidup = gaya
                )
                onSimulasiClick(input)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Simulasi", color = Color(0xFF20B2AA))
        }

        Spacer(modifier = Modifier.height(80.dp)) // kasih spasi ekstra agar tombol tidak tertutup
    }
}




