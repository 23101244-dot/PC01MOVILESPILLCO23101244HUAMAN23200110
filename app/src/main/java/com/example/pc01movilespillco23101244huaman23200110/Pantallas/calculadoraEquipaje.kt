package com.example.pc01movilespillco23101244huaman23200110.Pantallas


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CalculadoraEquipaje() {
    var peso by remember { mutableStateOf("") }
    var tipoVuelo by remember { mutableStateOf("Nacional") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora de Equipaje", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso de la maleta (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Seleccione el tipo de vuelo:")

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoVuelo == "Nacional",
                onClick = { tipoVuelo = "Nacional" }
            )
            Text("Nacional (Máx 23 kg)")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoVuelo == "Internacional",
                onClick = { tipoVuelo = "Internacional" }
            )
            Text("Internacional (Máx 32 kg)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val pesoNum = peso.toDoubleOrNull()
                if (pesoNum == null || pesoNum <= 0) {
                    resultado = "Error: Ingrese un peso válido mayor a cero."
                } else {
                    val limite = if (tipoVuelo == "Nacional") 23.0 else 32.0
                    if (pesoNum <= limite) {
                        resultado = "El equipaje cumple el límite permitido."
                    } else {
                        val exceso = pesoNum - limite
                        resultado = "El equipaje excede el límite permitido por $exceso kg."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            Text(resultado, style = MaterialTheme.typography.bodyLarge)
        }
    }
}