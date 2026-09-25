package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel()) {
    Column(modifier) {
        Text("Bienestar diario", Modifier.padding(16.dp), style = MaterialTheme.typography.headlineMedium)
        StatefulCounter()
        HorizontalDivider()
        Text("Tareas de bienestar", Modifier.padding(16.dp), style = MaterialTheme.typography.titleMedium)
        WellnessTasksList(wellnessViewModel.tasks, wellnessViewModel::changeTaskChecked,
            wellnessViewModel::remove, Modifier.weight(1f))
    }
}
