
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
fun WithdrawScreen(nav: NavController) {
    var amount by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp)) {
        Text("Withdraw", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold)
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
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("$25","$50","$100","MAX").forEach {
                Box(Modifier.background(Surface, RoundedCornerShape(14.dp)).padding(11.dp, 8.dp)) {
                    Text(it, color = TextMain, fontSize = 13.sp, fontWeight = FontWeight.Bold)
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
            Text("Request Withdrawal", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
        }
        BottomTabBar(nav, "home")
    }
}
