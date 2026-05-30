package com.example.pc01movilespillco23101244huaman23200110.Pantallas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pc01movilespillco23101244huaman23200110.Destination.destinos

val mockDestinos = listOf(
    destinos("Perú", "Cusco", 500.0, "https://flagcdn.com/w320/pe.png"),
    destinos("Francia", "París", 1200.0, "https://flagcdn.com/w320/fr.png"),
    destinos("EEUU", "Nueva York", 1500.0, "https://flagcdn.com/w320/us.png"),
    destinos("Japón", "Tokio", 2000.0, "https://flagcdn.com/w320/jp.png"),
    destinos("Brasil", "Río de Janeiro", 800.0, "https://flagcdn.com/w320/br.png")
)

@Composable
fun CatalogoDestinosScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Catálogo de Destinos Turísticos", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(mockDestinos) { destino ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Row(modifier = Modifier.padding(12.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(destino.url),
                            contentDescription = destino.ciudad,
                            modifier = Modifier.size(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("${destino.pais} - ${destino.ciudad}", style = MaterialTheme.typography.titleMedium)
                            Text("Costo promedio: ${destino.costo}")
                        }
                    }
                }
            }
            item {
                val total = mockDestinos.sumOf { it.costo }
                Text("Totl destinos: ${mockDestinos.size}", style = MaterialTheme.typography.bodyLarge)
                Text("Suma acumulada de costos: $total", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
