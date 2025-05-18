package com.example.okegass1.ui.theme

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController, email: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    // Ambil nama dari SharedPreferences yang sesuai
    LaunchedEffect(Unit) {
        val prefs = context.getSharedPreferences("user_profile", Context.MODE_PRIVATE)
        nama = prefs.getString("nama", "") ?: ""
        email = prefs.getString("email", "") ?: ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(72.dp))

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",
            modifier = Modifier.size(120.dp),
            tint = Color(0xFF009688)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            if (nama.isNotEmpty()) nama else "USER",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(email, style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("edit_profile") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Edit Profile", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Divider()

        ProfileMenuItem(
            icon = Icons.Default.Person,
            text = "Informasi Pribadi",
            onClick = { navController.navigate("informasi_pribadi") }
        )

        ProfileMenuItem(
            icon = Icons.Default.Notifications,
            text = "Notifikasi",
            onClick = { navController.navigate("notifikasi") }
        )

        Divider(modifier = Modifier.padding(top = 16.dp))

        ProfileMenuItem(
            icon = Icons.Default.ExitToApp,
            text = "Log Out",
            color = Color(0xFF004D40),
            onClick = {
                navController.navigate("login") {
                    popUpTo("home") { inclusive = true }
                }
            }
        )
    }
}


@Composable
fun ProfileMenuItem(
    icon: ImageVector,
    text: String,
    color: Color = Color(0xFF009688),
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = color)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, modifier = Modifier.weight(1f))
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}
