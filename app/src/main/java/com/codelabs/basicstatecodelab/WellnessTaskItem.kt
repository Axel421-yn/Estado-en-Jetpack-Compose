package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItem(taskName: String, checked: Boolean,
    onCheckedChange: (Boolean) -> Unit, onClose: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(taskName, Modifier.weight(1f).padding(start = 16.dp))
        Checkbox(checked, onCheckedChange,
            Modifier.semantics { contentDescription = "Completar $taskName" })
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Eliminar $taskName")
        }
    }
}
