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
fun PlanificadorPresupuesto() {
    var vuelo by remember { mutableStateOf("") }
    var alojamiento by remember { mutableStateOf("") }
    var actividades by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Presupuesto de Viaje", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = vuelo,
            onValueChange = { vuelo = it },
            label = { Text("Costo del Vuelo ($)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = alojamiento,
            onValueChange = { alojamiento = it },
            label = { Text("Costo de Alojamiento ($)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = actividades,
            onValueChange = { actividades = it },
            label = { Text("Costo de Actividades ($)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val valVuelo = vuelo.toDoubleOrNull() ?: 0.0
                val valAlojamiento = alojamiento.toDoubleOrNull() ?: 0.0
                val valActividades = actividades.toDoubleOrNull() ?: 0.0
                val total = valVuelo + valAlojamiento + valActividades

                if (total > 0) {
                    resultado = "Tu presupuesto total es: $$total"
                } else {
                    resultado = "Error: Ingresa montos válidos."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Presupuesto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            Text(resultado, style = MaterialTheme.typography.bodyLarge)
        }
    }
}