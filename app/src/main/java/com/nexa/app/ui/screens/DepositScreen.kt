
package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nexa.app.ui.theme.*

@Composable
fun DepositScreen(nav: NavController) {
    var amount by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp)) {
        Text("Deposit", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(22.dp))
        Text("Amount (USD)", color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            placeholder = { Text("$ 0.00", color = Color(0xFF2C4438), fontSize = 30.sp, fontWeight = FontWeight.ExtraBold) },
            modifier = Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(Modifier.height(8.dp))
        Text("Minimum deposit is $1.00", color = Dim, fontSize = 11.5.sp)
        Spacer(Modifier.height(22.dp))
        Text("Payment Method", color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            listOf("bKash" to "Mobile banking", "USDT" to "TRC20 · Tron", "Litecoin" to "LTC network", "Nexa User" to "Instant · 0% fee").forEach { (n,t) ->
                Box(Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(18.dp)).padding(13.dp,14.dp)) {
                    Column {
                        Text(n, color = TextMain, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        Text(t, color = Dim, fontSize = 11.sp)
                    }
                }
            }
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { nav.popBackStack() },
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text("Continue", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
        }
        BottomTabBar(nav, "home")
    }
}
