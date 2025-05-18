package com.example.okegass1.ui.theme

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformasiPribadiScreen(
    navController: NavController,
    userEmail: String
) {
    val turquoise = Color(0xFF20B2AA)
    val context = LocalContext.current

    // Ambil nilai tersimpan atau default kosong
    var nama by remember { mutableStateOf(getSavedValue(context, "nama") ?: "") }
    var nomorTelepon by remember { mutableStateOf(getSavedValue(context, "telepon") ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Informasi Pribadi", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = turquoise)
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input Nama
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text("Nama Lengkap") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Email (readonly)
            OutlinedTextField(
                value = userEmail,
                onValueChange = {},
                label = { Text("Email") },
                singleLine = true,
                enabled = false,
                modifier = Modifier.fillMaxWidth()
            )

            // Input Nomor Telepon
            OutlinedTextField(
                value = nomorTelepon,
                onValueChange = { nomorTelepon = it },
                label = { Text("Nomor Telepon") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Tombol Simpan
            Button(
                onClick = {
                    saveToPrefs(context, "nama", nama)
                    saveToPrefs(context, "telepon", nomorTelepon)
                    navController.popBackStack()
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Simpan")
            }
        }
    }
}

// Fungsi simpan data
fun saveToPrefs(context: Context, key: String, value: String) {
    val prefs = context.getSharedPreferences("user_profile", Context.MODE_PRIVATE)
    prefs.edit().putString(key, value).apply()
}

// Fungsi ambil data
fun getSavedValue(context: Context, key: String): String? {
    val prefs = context.getSharedPreferences("user_profile", Context.MODE_PRIVATE)
    return prefs.getString(key, null)
}
