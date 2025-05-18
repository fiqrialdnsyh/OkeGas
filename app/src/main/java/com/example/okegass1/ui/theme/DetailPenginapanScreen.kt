package com.example.okegass1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPenginapanScreen(
    nama: String,
    kota: String,
    harga: String,
    imageRes: Int,
    navController: NavHostController
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = nama, style = MaterialTheme.typography.titleLarge)
        Text(text = kota, style = MaterialTheme.typography.bodyMedium)
        Text(text = harga, style = MaterialTheme.typography.bodyMedium)
    }
}
