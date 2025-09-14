package org.kzerkovich.pulse.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class PulseColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val dividerColor: Color
)

object PulseTheme {
    val colors: PulseColors
        @Composable
        get() = LocalPulseColor.current
}

val LocalPulseColor =
    staticCompositionLocalOf<PulseColors> { error("No default implementation for colors") }