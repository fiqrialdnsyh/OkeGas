package com.example.okegass1.ui.theme

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.okegass1.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavController) {
    val primaryColor = Color(0xFF20B2AA)
    val context = LocalContext.current

    // Ambil nilai tersimpan atau default kosong
    var nama by remember { mutableStateOf(getSavedValue(context, "nama") ?: "") }
    var nomorTelepon by remember { mutableStateOf(getSavedValue(context, "telepon") ?: "") }
    var userEmail by remember { mutableStateOf(getSavedValue(context, "email") ?: "") }

    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profil") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Foto profil
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .background(primaryColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_okegas),
                    contentDescription = "Foto Profil",
                    modifier = Modifier.size(80.dp)
                )
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Ubah Foto",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .background(primaryColor, shape = CircleShape)
                        .padding(6.dp)
                        .size(24.dp)
                )
            }

            // Input Field
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
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Simpan Perubahan", color = Color.White)
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