package com.example.pc01movilespillco23101244huaman23200110.Navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pc01movilespillco23101244huaman23200110.Pantallas.MenuPrincipal
import com.example.pc01movilespillco23101244huaman23200110.Pantallas.CalculadoraEquipaje
import com.example.pc01movilespillco23101244huaman23200110.Pantallas.PlanificadorPresupuesto

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuPrincipal(navController = navController)
        }
        composable("Equipaje") {
            CalculadoraEquipaje()
        }

        composable("Presupuesto") {
            PlanificadorPresupuesto()
        }
    }
}
