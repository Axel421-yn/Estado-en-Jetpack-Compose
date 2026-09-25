package com.codelabs.basicstatecodelab

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WellnessUiTest {
    @get:Rule val compose = createAndroidComposeRule<MainActivity>()

    @Test fun counterStopsAtTen() {
        compose.onNodeWithTag("count").assertDoesNotExist()
        repeat(10) { compose.onNodeWithTag("addWater").performClick() }
        compose.onNodeWithText("Has tomado 10 vasos de agua.").assertIsDisplayed()
        compose.onNodeWithTag("addWater").assertIsNotEnabled()
    }

    @Test fun checkDeleteScrollAndRecreatePreserveState() {
        repeat(3) { compose.onNodeWithTag("addWater").performClick() }
        compose.onNodeWithContentDescription("Completar Tarea # 1").performClick().assertIsOn()
        compose.onNodeWithContentDescription("Eliminar Tarea # 0").performClick()
        compose.onNodeWithText("Tarea # 0").assertDoesNotExist()
        compose.onNodeWithTag("tasks").performScrollToIndex(28)
        compose.onNodeWithTag("tasks").performScrollToIndex(0)
        compose.onNodeWithContentDescription("Completar Tarea # 1").assertIsOn()
        compose.activityRule.scenario.recreate()
        compose.onNodeWithText("Has tomado 3 vasos de agua.").assertIsDisplayed()
        compose.onNodeWithContentDescription("Completar Tarea # 1").assertIsOn()
        compose.onNodeWithText("Tarea # 0").assertDoesNotExist()
    }
}
