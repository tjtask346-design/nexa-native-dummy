package com.nexa.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Bg = Color(0xFF040A07)
val Surface = Color(0xFF0B1C16)
val Surface2 = Color(0xFF0F261D)
val Surface3 = Color(0xFF153025)
val Border = Color(0x174ADE80) // rgba(74,222,128,.09)
val Border2 = Color(0x384ADE80) // rgba(74,222,128,.22)
val TextMain = Color(0xFFEEFBF4)
val Muted = Color(0xFF7FA694)
val Dim = Color(0xFF4D6B5E)
val Green = Color(0xFF4ADE80)
val Teal = Color(0xFF2DD4BF)
val Red = Color(0xFFF87171)

private val NexaDarkScheme = darkColorScheme(
    primary = Green,
    background = Bg,
    surface = Surface,
    onBackground = TextMain,
    onSurface = TextMain
)

@Composable
fun NexaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NexaDarkScheme,
        content = content
    )
}
