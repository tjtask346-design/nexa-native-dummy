package com.nexa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nexa.app.ui.theme.*

@Composable
fun HomeScreen(nav: NavController) {
    var balanceHidden by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxSize().background(Bg)) {
        Row(Modifier.fillMaxWidth().padding(22.dp, 20.dp, 20.dp, 6.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(42.dp).background(Brush.linearGradient(listOf(Green, Teal)), RoundedCornerShape(14.dp)), contentAlignment = Alignment.Center) {
                Text("N", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text("Welcome back \uD83D\uDC4B", color = Muted, fontSize = 12.sp)
                Text("Rakib", color = TextMain, fontSize = 15.5.sp, fontWeight = FontWeight.Bold)
            }
            Box(Modifier.size(40.dp).background(Surface2, RoundedCornerShape(13.dp)), contentAlignment = Alignment.Center) {
                Text("\uD83D\uDD14", fontSize = 17.sp)
            }
        }
        Box(Modifier.fillMaxWidth().padding(20.dp, 16.dp, 20.dp, 0.dp).background(Brush.linearGradient(listOf(Color(0xFF0F2E21), Color(0xFF143D2C), Color(0xFF0A2620))), RoundedCornerShape(26.dp)).padding(22.dp)) {
            Column {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total Balance", color = Color(0xB8EEFBF4), fontSize = 12.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                    Box(Modifier.size(32.dp).background(Color(0x14FFFFFF), RoundedCornerShape(10.dp)), contentAlignment = Alignment.Center) { Text("\uD83D\uDC41\uFE0F", fontSize = 14.sp) }
                }
                Spacer(Modifier.height(10.dp))
                Text(
                    text = if (balanceHidden) "•••••••" else "\$1,245.75",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = TextStyle(brush = Brush.linearGradient(listOf(Color.White, Color(0xFFA7F3D0))))
                )
                Text(text = if (balanceHidden) "≈ ৳ ••••••" else "≈ ৳1,49,490.00", color = Color(0x99EEFBF4), fontSize = 13.sp)
                Spacer(Modifier.height(18.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                    Box(Modifier.weight(1f).background(Color(0x8004140D), RoundedCornerShape(14.dp)).padding(9.dp, 11.dp)) {
                        Column {
                            Text("This Month In", color = Color(0x8CEEFBE4), fontSize = 10.5.sp)
                            Text("\$320.00", color = Green, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Box(Modifier.weight(1f).background(Color(0x8004140D), RoundedCornerShape(14.dp)).padding(9.dp, 11.dp)) {
                        Column {
                            Text("This Month Out", color = Color(0x8CEEFBE4), fontSize = 10.5.sp)
                            Text("\$115.00", color = Green, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
        Row(Modifier.fillMaxWidth().padding(20.dp, 20.dp, 20.dp, 4.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            ActionItem("Deposit", "↓", Color(0xFF4ADE80)) { nav.navigate("deposit") }
            ActionItem("Withdraw", "↑", Color(0xFF2DD4BF)) { nav.navigate("withdraw") }
            ActionItem("Scan", "◫", Color(0xFF4ADE80)) { nav.navigate("scan") }
            ActionItem("My QR", "⬙", Color(0xFF2DD4BF)) { nav.navigate("myqr") }
        }
        Row(Modifier.fillMaxWidth().padding(20.dp, 24.dp, 20.dp, 12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Quick Deposit", color = TextMain, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Row(Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            MethodCard("bKash", "0% fee", Color(0xFFE2136E))
            MethodCard("USDT", "Fee \$1", Color(0xFF26A17B))
            MethodCard("LTC", "Fee \$0.10", Color(0xFF345D9D))
            MethodCard("Nexa", "0% fee", Green)
        }
        Row(Modifier.fillMaxWidth().padding(20.dp, 24.dp, 20.dp, 12.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Recent Transactions", color = TextMain, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = { nav.navigate("history") }) { Text("See all", color = Teal, fontSize = 12.5.sp, fontWeight = FontWeight.Bold) }
        }
        Column(Modifier.padding(horizontal = 20.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
            TxItem("Deposit · bKash", "Today, 2:30 PM · NX-90231", "+\$120.00", true)
            TxItem("Withdraw · USDT", "Yesterday, 4:15 PM · NX-90214", "-\$75.00", false)
        }
        Spacer(Modifier.weight(1f))
        BottomTabBar(nav, "home")
    }
}

@Composable
fun ActionItem(label: String, icon: String, color: Color, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onClick, modifier = Modifier.size(52.dp), shape = RoundedCornerShape(18.dp), colors = ButtonDefaults.buttonColors(containerColor = Surface2), contentPadding = PaddingValues(0.dp)) {
            Text(icon, color = color, fontSize = 21.sp)
        }
        Spacer(Modifier.height(8.dp))
        Text(label, color = Muted, fontSize = 10.5.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MethodCard(name: String, fee: String, color: Color) {
    Box(Modifier.width(112.dp).background(Surface, RoundedCornerShape(18.dp)).padding(13.dp, 12.dp)) {
        Column {
            Box(Modifier.size(34.dp).background(color.copy(alpha=0.14f), RoundedCornerShape(11.dp)), contentAlignment = Alignment.Center) {
                Text(name.first().toString(), color = color, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(10.dp))
            Text(name, color = TextMain, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(fee, color = Dim, fontSize = 10.5.sp)
        }
    }
}

@Composable
fun TxItem(title: String, sub: String, amount: String, isIn: Boolean) {
    Row(Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(17.dp)).padding(13.dp, 14.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(40.dp).background(Green.copy(alpha=0.14f), RoundedCornerShape(13.dp)), contentAlignment = Alignment.Center) { Text("N", color = Green, fontWeight = FontWeight.ExtraBold) }
        Spacer(Modifier.width(13.dp))
        Column(Modifier.weight(1f)) {
            Text(title, color = TextMain, fontSize = 13.5.sp, fontWeight = FontWeight.SemiBold)
            Text(sub, color = Dim, fontSize = 11.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(amount, color = if(isIn) Green else TextMain, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Box(Modifier.background(if(isIn) Color(0x234ADE80) else Color(0x234ADE80), RoundedCornerShape(6.dp)).padding(7.dp, 2.dp)) {
                Text("Completed", color = Green, fontSize = 9.5.sp, fontWeight = FontWeight.ExtraBold)
            }
        }
    }
}

@Composable
fun BottomTabBar(nav: NavController, active: String) {
    Row(Modifier.fillMaxWidth().height(78.dp).background(Color(0xE006100C)).padding(horizontal = 12.dp), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
        TabItem("Home", "⌂", active=="home") { nav.navigate("home") }
        TabItem("History", "◷", active=="history") { nav.navigate("history") }
        Box(Modifier.size(56.dp).background(Brush.linearGradient(listOf(Green, Teal)), RoundedCornerShape(20.dp)), contentAlignment = Alignment.Center) { Text("+", fontSize = 26.sp, color = Color(0xFF04140D)) }
        TabItem("Scan", "◫", active=="scan") { nav.navigate("scan") }
        TabItem("Profile", "◍", active=="profile") { nav.navigate("profile") }
    }
}

@Composable
fun TabItem(label: String, icon: String, active: Boolean, onClick: () -> Unit) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), contentPadding = PaddingValues(8.dp, 0.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(icon, color = if(active) Green else Dim, fontSize = 22.sp)
            Text(label, color = if(active) Green else Dim, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
    }
}
