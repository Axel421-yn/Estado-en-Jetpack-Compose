package com.codelabs.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun WellnessTasksList(list: List<WellnessTask>, onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier.testTag("tasks")) {
        items(list, key = { it.id }) { task ->
            WellnessTaskItem(task.label, task.checked,
                { onCheckedTask(task, it) }, { onCloseTask(task) })
        }
    }
}
