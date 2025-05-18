package com.example.okegass1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class NotificationItem(val id: Int, val title: String, val message: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiScreen(navController: NavController, modifier: Modifier = Modifier) {
    // Contoh data dummy notifikasi
    val notifications = listOf(
        NotificationItem(1, "Update Aplikasi", "Versi terbaru sudah tersedia. Segera update untuk fitur terbaru."),
        NotificationItem(2, "Promo Diskon", "Nikmati diskon 20% untuk perjalanan ke Bali."),
        NotificationItem(3, "Pengingat", "Jangan lupa cek jadwal perjalananmu besok."),
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Notifikasi") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = modifier.fillMaxSize()
        ) {
            items(notifications) { notification ->
                NotificationCard(notification)
                Divider()
            }
        }
    }
}

@Composable
fun NotificationCard(notification: NotificationItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = notification.title, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = notification.message, style = MaterialTheme.typography.bodyMedium)
    }
}
