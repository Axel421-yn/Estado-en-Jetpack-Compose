package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

// El estado pequeño de UI se restaura al recrear la actividad.
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { if (count < 10) count++ }, modifier)
}

// Recibe estado y emite eventos: no decide dónde guardar los datos.
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {
        Text("Agua de hoy", style = MaterialTheme.typography.titleLarge)
        if (count > 0) {
            Text("Has tomado $count vasos de agua.", Modifier.padding(top = 8.dp).testTag("count"))
        }
        Button(onClick = onIncrement, enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp).testTag("addWater")) {
            Text("Agregar un vaso")
        }
    }
}
