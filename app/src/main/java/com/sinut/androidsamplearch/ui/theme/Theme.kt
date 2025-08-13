package com.example.compose

import android.os.Build
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.AppTypography
import com.sinut.androidsamplearch.ui.theme.backgroundDark
import com.sinut.androidsamplearch.ui.theme.backgroundLight
import com.sinut.androidsamplearch.ui.theme.errorContainerDark
import com.sinut.androidsamplearch.ui.theme.errorContainerLight
import com.sinut.androidsamplearch.ui.theme.errorDark
import com.sinut.androidsamplearch.ui.theme.errorLight
import com.sinut.androidsamplearch.ui.theme.inverseOnSurfaceDark
import com.sinut.androidsamplearch.ui.theme.inverseOnSurfaceLight
import com.sinut.androidsamplearch.ui.theme.inversePrimaryDark
import com.sinut.androidsamplearch.ui.theme.inversePrimaryLight
import com.sinut.androidsamplearch.ui.theme.inverseSurfaceDark
import com.sinut.androidsamplearch.ui.theme.inverseSurfaceLight
import com.sinut.androidsamplearch.ui.theme.onBackgroundDark
import com.sinut.androidsamplearch.ui.theme.onBackgroundLight
import com.sinut.androidsamplearch.ui.theme.onErrorContainerDark
import com.sinut.androidsamplearch.ui.theme.onErrorContainerLight
import com.sinut.androidsamplearch.ui.theme.onErrorDark
import com.sinut.androidsamplearch.ui.theme.onErrorLight
import com.sinut.androidsamplearch.ui.theme.onPrimaryContainerDark
import com.sinut.androidsamplearch.ui.theme.onPrimaryContainerLight
import com.sinut.androidsamplearch.ui.theme.onPrimaryDark
import com.sinut.androidsamplearch.ui.theme.onPrimaryLight
import com.sinut.androidsamplearch.ui.theme.onSecondaryContainerDark
import com.sinut.androidsamplearch.ui.theme.onSecondaryContainerLight
import com.sinut.androidsamplearch.ui.theme.onSecondaryDark
import com.sinut.androidsamplearch.ui.theme.onSecondaryLight
import com.sinut.androidsamplearch.ui.theme.onSurfaceDark
import com.sinut.androidsamplearch.ui.theme.onSurfaceLight
import com.sinut.androidsamplearch.ui.theme.onSurfaceVariantDark
import com.sinut.androidsamplearch.ui.theme.onSurfaceVariantLight
import com.sinut.androidsamplearch.ui.theme.onTertiaryContainerDark
import com.sinut.androidsamplearch.ui.theme.onTertiaryContainerLight
import com.sinut.androidsamplearch.ui.theme.onTertiaryDark
import com.sinut.androidsamplearch.ui.theme.onTertiaryLight
import com.sinut.androidsamplearch.ui.theme.outlineDark
import com.sinut.androidsamplearch.ui.theme.outlineLight
import com.sinut.androidsamplearch.ui.theme.outlineVariantDark
import com.sinut.androidsamplearch.ui.theme.outlineVariantLight
import com.sinut.androidsamplearch.ui.theme.primaryContainerDark
import com.sinut.androidsamplearch.ui.theme.primaryContainerLight
import com.sinut.androidsamplearch.ui.theme.primaryDark
import com.sinut.androidsamplearch.ui.theme.primaryLight
import com.sinut.androidsamplearch.ui.theme.scrimDark
import com.sinut.androidsamplearch.ui.theme.scrimLight
import com.sinut.androidsamplearch.ui.theme.secondaryContainerDark
import com.sinut.androidsamplearch.ui.theme.secondaryContainerLight
import com.sinut.androidsamplearch.ui.theme.secondaryDark
import com.sinut.androidsamplearch.ui.theme.secondaryLight
import com.sinut.androidsamplearch.ui.theme.surfaceBrightDark
import com.sinut.androidsamplearch.ui.theme.surfaceBrightLight
import com.sinut.androidsamplearch.ui.theme.surfaceContainerDark
import com.sinut.androidsamplearch.ui.theme.surfaceContainerHighDark
import com.sinut.androidsamplearch.ui.theme.surfaceContainerHighLight
import com.sinut.androidsamplearch.ui.theme.surfaceContainerHighestDark
import com.sinut.androidsamplearch.ui.theme.surfaceContainerHighestLight
import com.sinut.androidsamplearch.ui.theme.surfaceContainerLight
import com.sinut.androidsamplearch.ui.theme.surfaceContainerLowDark
import com.sinut.androidsamplearch.ui.theme.surfaceContainerLowLight
import com.sinut.androidsamplearch.ui.theme.surfaceContainerLowestDark
import com.sinut.androidsamplearch.ui.theme.surfaceContainerLowestLight
import com.sinut.androidsamplearch.ui.theme.surfaceDark
import com.sinut.androidsamplearch.ui.theme.surfaceDimDark
import com.sinut.androidsamplearch.ui.theme.surfaceDimLight
import com.sinut.androidsamplearch.ui.theme.surfaceLight
import com.sinut.androidsamplearch.ui.theme.surfaceVariantDark
import com.sinut.androidsamplearch.ui.theme.surfaceVariantLight
import com.sinut.androidsamplearch.ui.theme.tertiaryContainerDark
import com.sinut.androidsamplearch.ui.theme.tertiaryContainerLight
import com.sinut.androidsamplearch.ui.theme.tertiaryDark
import com.sinut.androidsamplearch.ui.theme.tertiaryLight


@VisibleForTesting
private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

