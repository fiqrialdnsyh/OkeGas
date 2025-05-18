package com.example.okegass1.ui.theme

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenginapanScreen(navController: NavController) {
    val turquoise = Color(0xFF20B2AA)
    val context = LocalContext.current

    var location by remember { mutableStateOf("") }
    var checkInDate by remember { mutableStateOf("Pilih Tanggal") }
    var checkOutDate by remember { mutableStateOf("Pilih Tanggal") }
    var guestCount by remember { mutableStateOf("1") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cari Penginapan", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = turquoise)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text("Temukan Penginapan Terbaik", fontSize = 20.sp, color = turquoise)
            Text("Pilih lokasi dan tanggal menginap", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .background(turquoise, RoundedCornerShape(24.dp))
                    .padding(24.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("DETAIL PENGINAPAN", fontSize = 16.sp, color = Color.White)

                    Spacer(modifier = Modifier.height(16.dp))

                    // Lokasi
                    OutlinedTextField(
                        value = location,
                        onValueChange = { location = it },
                        label = { Text("Lokasi (Provinsi)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Check-In
                    DatePickerField("Check-In", checkInDate) { checkInDate = it }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Check-Out
                    DatePickerField("Check-Out", checkOutDate) { checkOutDate = it }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Jumlah Tamu
                    OutlinedTextField(
                        value = guestCount,
                        onValueChange = { guestCount = it },
                        label = { Text("Jumlah Tamu") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Tombol Cari
                    Button(
                        onClick = {
                            val provinsi = location.trim()
                            if (provinsi.isNotEmpty()) {
                                navController.navigate("result_penginapan/$provinsi")
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("CARI PENGINAPAN", color = turquoise)
                    }
                }
            }
        }
    }
}

@Composable
fun DatePickerField(label: String, value: String, onDateSelected: (String) -> Unit) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        interactionSource.interactions.collect {
            if (it is androidx.compose.foundation.interaction.PressInteraction.Release) {
                showDialog = true
            }
        }
    }

    OutlinedTextField(
        value = value,
        onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        interactionSource = interactionSource,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            disabledTextColor = Color.Black,
            disabledContainerColor = Color.White
        )
    )

    if (showDialog) {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            context,
            { _, year, month, day ->
                val selected = "%02d/%02d/%04d".format(day, month + 1, year)
                onDateSelected(selected)
                showDialog = false
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).apply {
            setOnCancelListener { showDialog = false }
        }.show()
    }
}
