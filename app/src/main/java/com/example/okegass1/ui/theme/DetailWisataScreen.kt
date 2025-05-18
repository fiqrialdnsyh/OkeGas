package com.example.okegass1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.material3.TopAppBarDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWisataScreen(idWisata: Int, onBack: () -> Unit) {
    val wisata = DummyData.wisataList.find { it.id == idWisata }

    if (wisata == null) {
        Text("Data tidak ditemukan")
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(wisata.nama) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF20B2AA),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Gambar Tetap
            Image(
                painter = painterResource(id = wisata.imageRes),
                contentDescription = wisata.nama,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            // Konten Scrollable
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text(text = wisata.nama, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = wisata.lokasi, fontSize = 14.sp, color = Color.Gray)

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Text("⭐ ${wisata.rating}", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("${wisata.jumlahUlasan} ulasan", color = Color.Gray)
                }

                Text(
                    text = "Jam buka: ${wisata.jamBuka}",
                    fontSize = 14.sp,
                    color = Color(0xFF2E7D32),
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = wisata.deskripsi,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}