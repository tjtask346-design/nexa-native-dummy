
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
fun ProfileScreen(nav: NavController) {
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Profile", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(10.dp))
        Box(
            Modifier.size(86.dp).background(
                Brush.linearGradient(listOf(Green, Teal)),
                RoundedCornerShape(28.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            Text("N", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)
        }
        Spacer(Modifier.height(14.dp))
        Text("Rakib", color = TextMain, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Text("rakib@example.com", color = Muted, fontSize = 12.5.sp)
        Spacer(Modifier.height(12.dp))
        Box(Modifier.background(Color(0x1C2DD4BF), RoundedCornerShape(9.dp)).padding(11.dp,5.dp)) {
            Text("● Demo Mode", color = Teal, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
        }
        Spacer(Modifier.height(26.dp))
        Column(Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(20.dp))) {
            listOf("My QR Code" to "Receive instant Nexa payments", "Change PIN" to "Update your 5-digit security PIN", "Fingerprint" to "Biometric unlock enabled", "KYC Verification" to "Fully verified", "Support" to "24/7 live chat", "Log Out" to "Sign out").forEach { (t,s) ->
                Row(Modifier.fillMaxWidth().padding(17.dp,15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(34.dp).background(Surface3, RoundedCornerShape(11.dp)), contentAlignment = Alignment.Center) {
                        Text("•", color = TextMain)
                    }
                    Spacer(Modifier.width(13.dp))
                    Column(Modifier.weight(1f)) {
                        Text(t, color = TextMain, fontSize = 13.5.sp, fontWeight = FontWeight.SemiBold)
                        Text(s, color = Dim, fontSize = 11.sp)
                    }
                    Text("›", color = Dim, fontSize = 16.sp)
                }
            }
        }
        Spacer(Modifier.weight(1f))
        BottomTabBar(nav, "profile")
    }
}
