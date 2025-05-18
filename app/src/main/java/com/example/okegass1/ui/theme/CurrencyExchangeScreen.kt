package com.example.okegass1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyExchangeScreen(navController: NavController) {
    val turquoise = Color(0xFF20B2AA)
    val coroutineScope = rememberCoroutineScope()

    var amount by remember { mutableStateOf("0") }
    var fromCurrency by remember { mutableStateOf("USD") }
    var toCurrency by remember { mutableStateOf("IDR") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val currencies = listOf("USD", "IDR", "EUR", "JPY", "SGD")

    //API key
    val apiKey = "8177e3e4dc5c4f72f151570af87b4b26"

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    TextButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = turquoise)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Kembali", color = turquoise)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
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
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                "Currency Exchange",
                fontSize = 22.sp,
                color = turquoise
            )
            Text(
                "Periksa nilai tukar mata uang asing secara langsung",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .background(turquoise, RoundedCornerShape(24.dp))
                    .padding(24.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("CONVERT", fontSize = 16.sp, color = Color.White)

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = amount,
                        onValueChange = { amount = it },
                        label = { Text("Amount") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    CurrencySelector(label = "From", selected = fromCurrency, options = currencies) {
                        fromCurrency = it
                    }

                    IconButton(onClick = {
                        val temp = fromCurrency
                        fromCurrency = toCurrency
                        toCurrency = temp
                    }) {
                        Icon(
                            Icons.Default.CompareArrows,
                            contentDescription = "Swap",
                            tint = Color.White
                        )
                    }

                    CurrencySelector(label = "To", selected = toCurrency, options = currencies) {
                        toCurrency = it
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            coroutineScope.launch {
                                errorMessage = null
                                if(amount.isBlank() || amount.toDoubleOrNull() == null) {
                                    errorMessage = "Masukkan nominal valid"
                                    return@launch
                                }
                                isLoading = true
                                val resultString = convertCurrency(fromCurrency, toCurrency, amount, apiKey)
                                isLoading = false

                                if (resultString.startsWith("Gagal")) {
                                    errorMessage = resultString
                                } else {
                                    // Dummy rates
                                    val rateFromTo = "16,494.8" // USD->IDR
                                    val rateToFrom = "0.0000606252" // IDR->USD

                                    navController.navigate(
                                        "result_currency_exchange/" +
                                                "${amount}/" +
                                                "$fromCurrency/${currencyName(fromCurrency)}/" +
                                                "$toCurrency/${currencyName(toCurrency)}/" +
                                                "$resultString/" +
                                                rateFromTo.replace(",", "%2C") + "/" +
                                                rateToFrom
                                    )
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text("CONVERT", color = turquoise)
                    }

                    if (errorMessage != null) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(errorMessage!!, color = Color.Red)
                    }

                    if (isLoading) {
                        Spacer(modifier = Modifier.height(12.dp))
                        CircularProgressIndicator(color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencySelector(label: String, selected: String, options: List<String>, onSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(label, color = Color.White, fontSize = 12.sp)
        DropdownMenuBox(selected = selected, options = options, onSelected = onSelected)
    }
}

@Composable
fun DropdownMenuBox(selected: String, options: List<String>, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { expanded = true }
            .padding(12.dp)
    ) {
        Text(selected, color = Color.Black)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}

suspend fun convertCurrency(from: String, to: String, amount: String, apiKey: String): String {
    return try {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true //untuk menghindari error kunci tidak dikenal
                })
            }
        }

        val response = client.get("https://api.exchangerate.host/convert") {
            parameter("access_key", "8177e3e4dc5c4f72f151570af87b4b26") // API key
            parameter("from", from)
            parameter("to", to)
            parameter("amount", amount)
        }

        val data: ExchangeResponse = response.body()
        "%.2f".format(data.result)
    } catch (e: Exception) {
        "Gagal: ${e.message}"
    }
}

fun currencyName(code: String): String = when (code) {
    "USD" -> "US Dollar"
    "IDR" -> "Indonesian Rupiah"
    "EUR" -> "Euro"
    "JPY" -> "Japanese Yen"
    "SGD" -> "Singapore Dollar"
    else -> "Unknown"
}

@Serializable
data class ExchangeResponse(
    val result: Double
)
