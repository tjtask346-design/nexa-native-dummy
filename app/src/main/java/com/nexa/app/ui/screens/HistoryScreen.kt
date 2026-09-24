
package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nexa.app.ui.theme.*

@Composable
fun HistoryScreen(nav: NavController) {
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp)) {
        Text("Transaction History", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(14.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("All","Deposits","Withdrawals","Sent").forEachIndexed { i, t ->
                Box(
                    Modifier.background(
                        if(i==0) Color(0x1E4ADE80) else Surface,
                        RoundedCornerShape(12.dp)
                    ).padding(16.dp, 9.dp)
                ) {
                    Text(t, color = if(i==0) Green else Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
        Spacer(Modifier.height(20.dp))
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            TxItem("Deposit · bKash", "Today, 2:30 PM · NX-90231", "+$120.00", true)
            TxItem("Withdraw · USDT", "Yesterday · NX-90214", "-$75.00", false)
        }
        Spacer(Modifier.weight(1f))
        BottomTabBar(nav, "history")
    }
}
