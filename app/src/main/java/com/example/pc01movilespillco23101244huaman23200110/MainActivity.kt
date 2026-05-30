package com.example.pc01movilespillco23101244huaman23200110

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pc01movilespillco23101244huaman23200110.Navegacion.AppNavegacion
import com.example.pc01movilespillco23101244huaman23200110.Pantallas.CalculadoraEquipaje
import com.example.pc01movilespillco23101244huaman23200110.Pantallas.MenuPrincipal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavegacion()
        }
    }
}