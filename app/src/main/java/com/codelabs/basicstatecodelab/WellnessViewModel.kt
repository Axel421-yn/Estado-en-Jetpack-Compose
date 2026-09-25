package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = List(30) { WellnessTask(it, "Tarea # $it") }.toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun remove(item: WellnessTask) { _tasks.removeAll { it.id == item.id } }
    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.checked = checked
    }
}
