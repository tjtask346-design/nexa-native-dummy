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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexa.app.ui.theme.*

@Composable
fun LoginScreen(onLogin: (String) -> Unit, onSignupClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    
    Column(
        Modifier
            .fillMaxSize()
            .background(Bg)
            .padding(26.dp)
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(56.dp))
            Box(
                Modifier
                    .size(88.dp)
                    .background(
                        Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF2DD4BF))),
                        RoundedCornerShape(24.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("N", color = Color(0xFF04140D), fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(16.dp))
            Text("NEXA", letterSpacing = 6.sp, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp,
                brush = Brush.linearGradient(listOf(Green, Teal))
            )
        }
        
        Spacer(Modifier.height(34.dp))
        Text("Welcome back 👋", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, color = TextMain)
        Text("Enter your email to continue.
You'll verify with your 5-digit PIN.", 
            color = Muted, fontSize = 13.5.sp, modifier = Modifier.padding(top=8.dp, bottom=30.dp))
        
        // Input group - exact like HTML .input-group
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("you@example.com", color = Color(0xFF3B574A)) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Surface, RoundedCornerShape(17.dp)),
            shape = RoundedCornerShape(17.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0x884ADE80),
                unfocusedBorderColor = Border
            )
        )
        
        Spacer(Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🔒", fontSize = 14.sp)
            Spacer(Modifier.width(9.dp))
            Text("Secured with a 5-digit PIN & fingerprint. No passwords to remember.",
                color = Muted, fontSize = 11.5.sp)
        }
        
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { onLogin(email) },
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text("Continue with Email", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
        }
        
        Spacer(Modifier.height(24.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Don't have an account? ", color = Muted, fontSize = 13.sp)
            TextButton(onClick = onSignupClick) {
                Text("Sign up", color = Green, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
            }
        }
        
        Spacer(Modifier.weight(1f))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("SECURE & TRUSTED", color = Dim, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.5.sp)
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TrustChip("🔒 256-bit encryption")
            Spacer(Modifier.width(8.dp))
            TrustChip("👆 Biometric ready")
            Spacer(Modifier.width(8.dp))
            TrustChip("✅ KYC verified")
        }
    }
}

@Composable
fun TrustChip(text: String) {
    Box(
        Modifier
            .background(Surface, RoundedCornerShape(11.dp))
            .padding(horizontal = 13.dp, vertical = 8.dp)
    ) {
        Text(text, color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SignupScreen(onSignup: (String) -> Unit, onLoginClick: () -> Unit) {
    var email by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize().background(Bg).padding(26.dp)
    ) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(40.dp))
            Box(
                Modifier.size(88.dp).background(
                    Brush.linearGradient(listOf(Color(0xFF4ADE80), Color(0xFF2DD4BF))),
                    RoundedCornerShape(24.dp)
                ),
                contentAlignment = Alignment.Center
            ) {
                Text("N", color = Color(0xFF04140D), fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(16.dp))
            Text("NEXA", letterSpacing = 6.sp, fontWeight = FontWeight.ExtraBold, fontSize = 14.sp,
                brush = Brush.linearGradient(listOf(Green, Teal))
            )
        }
        Spacer(Modifier.height(34.dp))
        Text("Create your account", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, color = TextMain)
        Text("Email-only registration — done in 30 seconds.
Then set your secure 5-digit PIN.",
            color = Muted, fontSize = 13.5.sp, modifier = Modifier.padding(top=8.dp, bottom=30.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("you@example.com", color = Color(0xFF3B574A)) },
            modifier = Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(17.dp)),
            shape = RoundedCornerShape(17.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0x884ADE80),
                unfocusedBorderColor = Border
            )
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { onSignup(email) },
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text("Create Free Account", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
        }
        Spacer(Modifier.height(24.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text("Already have an account? ", color = Muted, fontSize = 13.sp)
            TextButton(onClick = onLoginClick) {
                Text("Log in", color = Green, fontWeight = FontWeight.ExtraBold, fontSize = 13.sp)
            }
        }
    }
}
