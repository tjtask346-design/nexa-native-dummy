package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexa.app.ui.theme.*

@Composable
fun PinScreen(mode: String, onSuccess: () -> Unit) {
    var pin by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val isSetup = mode == "setup"
    
    Column(
        Modifier.fillMaxSize().background(Bg).padding(22.dp)
    ) {
        // Back button
        Box(
            Modifier.size(40.dp).background(Surface, RoundedCornerShape(13.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("←", color = TextMain, fontSize = 18.sp)
        }
        
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(56.dp))
            Box(
                Modifier.size(64.dp).background(
                    Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF2DD4BF))),
                    RoundedCornerShape(20.dp)
                ),
                contentAlignment = Alignment.Center
            ) {
                Text("N", color = Color(0xFF04140D), fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(20.dp))
            Text(
                if (isSetup) "Create your PIN" else "Enter your PIN",
                fontSize = 22.sp, fontWeight = FontWeight.ExtraBold, color = TextMain
            )
            Text(
                if (isSetup) "Choose a 5-digit PIN to secure your account" else "Enter your 5-digit PIN to unlock Nexa",
                color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top=8.dp)
            )
            
            Spacer(Modifier.height(44.dp))
            // Dots - exact like HTML .pin-dots
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                repeat(5) { i ->
                    Box(
                        Modifier.size(16.dp).background(
                            if (i < pin.length) Green else Color.Transparent,
                            CircleShape
                        ).let {
                            if (i >= pin.length) it.background(Color.Transparent, CircleShape)
                            else it
                        }
                    ) {
                        if (i >= pin.length) {
                            Box(
                                Modifier.fillMaxSize().background(
                                    Color.Transparent, CircleShape
                                )
                            ) {
                                // border
                            }
                        }
                    }
                }
            }
            // Dots with border
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(top=0.dp)) {
                repeat(5) { i ->
                    val filled = i < pin.length
                    Box(
                        Modifier
                            .size(16.dp)
                            .background(
                                if (filled) Green else Color.Transparent,
                                CircleShape
                            )
                    ) {
                        if (!filled) {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .background(Color.Transparent, CircleShape)
                            )
                        }
                    }
                }
            }
            if (error.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))
                Text(error, color = Red, fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        
        Spacer(Modifier.weight(1f))
        
        // Keypad - exact like HTML .pin-keypad
        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            val keys = listOf(
                listOf("1","2","3"),
                listOf("4","5","6"),
                listOf("7","8","9"),
                listOf("fp","0","del")
            )
            keys.forEach { row ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(11.dp)
                ) {
                    row.forEach { k ->
                        when(k) {
                            "fp" -> {
                                Box(
                                    Modifier.weight(1f).aspectRatio(1.45f)
                                        .background(Color(0x144ADE80), RoundedCornerShape(22.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("👆", fontSize = 24.sp)
                                }
                            }
                            "del" -> {
                                Button(
                                    onClick = { pin = pin.dropLast(1) },
                                    modifier = Modifier.weight(1f).aspectRatio(1.45f),
                                    shape = RoundedCornerShape(22.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Surface)
                                ) {
                                    Text("⌫", fontSize = 22.sp, color = Muted)
                                }
                            }
                            else -> {
                                Button(
                                    onClick = {
                                        if (pin.length < 5) {
                                            pin += k
                                            if (pin.length == 5) {
                                                // Success
                                                onSuccess()
                                            }
                                        }
                                    },
                                    modifier = Modifier.weight(1f).aspectRatio(1.45f),
                                    shape = RoundedCornerShape(22.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Surface)
                                ) {
                                    Text(k, fontSize = 25.sp, fontWeight = FontWeight.SemiBold, color = TextMain)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
