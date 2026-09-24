
package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nexa.app.ui.theme.*

@Composable
fun MyQrScreen(nav: NavController) {
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("My QR Code", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(22.dp))
        Box(
            Modifier.fillMaxWidth().background(
                Brush.linearGradient(listOf(Color(0xFF0D2519), Color(0xFF0A1C15))),
                RoundedCornerShape(30.dp)
            ).padding(28.dp, 22.dp, 26.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(210.dp).background(Color.White, RoundedCornerShape(22.dp)), contentAlignment = Alignment.Center) {
                    Text("QR CODE", color = Color.Black, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(18.dp))
                Text("Scan to pay me instantly", color = TextMain, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp)
                Text("0% fee · Instant credit · Nexa-to-Nexa", color = Muted, fontSize = 11.5.sp)
            }
        }
        Spacer(Modifier.weight(1f))
        BottomTabBar(nav, "home")
    }
}
