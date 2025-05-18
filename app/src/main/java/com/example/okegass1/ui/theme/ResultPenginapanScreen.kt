package com.example.okegass1.ui.theme   // ganti jika disimpan di package lain

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.foundation.clickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultPenginapanScreen(navController: NavController, provinsi: String) {

    val turquoise = Color(0xFF20B2AA)
    //list bertipe List<Penginapan>; di-remember agar tidak dihitung ulang
    val list = remember(provinsi) { DummyData.getPenginapan(provinsi) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Penginapan di $provinsi", color = Color.White) },
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
                .fillMaxSize()
                .background(Color.White)
                .padding(padding)
        ) {
            if (list.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Tidak ada penginapan ditemukan untuk provinsi ini.")
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(list) { p ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(4.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(
                                        "detailPenginapan/${p.nama}/${p.kota}/${p.harga}/${p.imageRes}"
                                    )
                                }
                        ) {
                            Column {
                                Image(
                                    painter = painterResource(p.imageRes),
                                    contentDescription = p.nama,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp)
                                )
                                Column(Modifier.padding(16.dp)) {
                                    Text(p.nama, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                    Text(p.kota, fontSize = 14.sp, color = Color.Gray)
                                    Spacer(Modifier.height(4.dp))
                                    Text(p.harga, color = turquoise, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
