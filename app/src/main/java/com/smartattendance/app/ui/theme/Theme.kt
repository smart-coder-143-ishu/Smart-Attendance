package com.smartattendance.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val PrimaryIndigo = Color(0xFF4F46E5)
val SecondaryIndigo = Color(0xFF6366F1)
val TertiaryEmerald = Color(0xFF10B981)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF818CF8),
    secondary = Color(0xFFA5B4FC),
    tertiary = Color(0xFF34D399)
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryIndigo,
    secondary = SecondaryIndigo,
    tertiary = TertiaryEmerald
)

@Composable
fun SmartAttendanceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
