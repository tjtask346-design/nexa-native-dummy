package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexa.app.ui.theme.Bg
import com.nexa.app.ui.theme.Green
import com.nexa.app.ui.theme.Muted
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onFinish: (Boolean) -> Unit) {
    var progress by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        // Simulate loading like HTML
        delay(2000)
        onFinish(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Bg),
        contentAlignment = Alignment.Center
    ) {
        // Glow effects like HTML ::before ::after
        Box(
            Modifier
                .size(360.dp)
                .offset((-90).dp, (-190).dp)
                .background(
                    Brush.radialGradient(
                        listOf(Color(0x384ADE80), Color.Transparent)
                    ),
                    RoundedCornerShape(180.dp)
                )
                .blur(34.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Logo box - 150px, rounded 36px, glow
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF2DD4BF))),
                        RoundedCornerShape(36.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("N", color = Color(0xFF04140D), fontSize = 64.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(26.dp))
            Text(
                "NEXA",
                fontSize = 36.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 8.sp,
                brush = Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF22C55E), Color(0xFF2DD4BF))),
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                "Move Money Freely",
                color = Muted,
                fontSize = 12.5.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.5.sp
            )
            Spacer(Modifier.height(80.dp))
            // Loader - exact center like HTML fix
            Box(
                Modifier
                    .width(130.dp)
                    .height(3.dp)
                    .background(Color(0xFF153025), RoundedCornerShape(3.dp))
            ) {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .width(65.dp)
                        .background(
                            Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF2DD4BF))),
                            RoundedCornerShape(3.dp)
                        )
                )
            }
        }
    }
}
