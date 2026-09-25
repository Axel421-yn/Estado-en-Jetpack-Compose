package com.codelabs.basicstatecodelab

import org.junit.Assert.*
import org.junit.Test

class WellnessViewModelTest {
    @Test fun initialTasksHaveUniqueIdsAndAreUnchecked() {
        val model = WellnessViewModel()
        assertEquals(30, model.tasks.size)
        assertEquals(30, model.tasks.map { it.id }.toSet().size)
        assertTrue(model.tasks.none { it.checked })
    }
    @Test fun checkingAndUncheckingDoesNotChangeOtherTasks() {
        val model = WellnessViewModel()
        val task = model.tasks[2]
        model.changeTaskChecked(task, true)
        assertTrue(task.checked)
        assertFalse(model.tasks[1].checked)
        model.changeTaskChecked(task, false)
        assertFalse(task.checked)
    }
    @Test fun deletingPreservesRemainingIdentityAndCheckedState() {
        val model = WellnessViewModel()
        val survivor = model.tasks[1]
        model.changeTaskChecked(survivor, true)
        model.remove(model.tasks[0])
        assertEquals(29, model.tasks.size)
        assertSame(survivor, model.tasks[0])
        assertTrue(model.tasks[0].checked)
        assertTrue(model.tasks.none { it.id == 0 })
    }
    @Test fun staleEventsDoNotRestoreRemovedTask() {
        val model = WellnessViewModel()
        val removed = model.tasks[0]
        model.remove(removed)
        model.remove(removed)
        model.changeTaskChecked(removed, true)
        assertEquals(29, model.tasks.size)
        assertFalse(removed.checked)
    }
}
