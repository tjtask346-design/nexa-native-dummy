
package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nexa.app.ui.theme.*

@Composable
fun ScanScreen(nav: NavController) {
    Box(Modifier.fillMaxSize().background(Color.Black), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                Modifier.size(290.dp).background(Color(0xFF0D2018), RoundedCornerShape(32.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Scan View", color = Green)
            }
            Spacer(Modifier.height(26.dp))
            Text("Point at a Nexa QR code", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp)
            Text("Align the QR code within the frame", color = Color(0x99FFFFFF), fontSize = 12.sp)
        }
    }
}
