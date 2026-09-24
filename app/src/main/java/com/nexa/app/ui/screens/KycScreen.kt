
package com.nexa.app.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import com.nexa.app.ui.theme.*

@Composable
fun KycScreen() {
    var nid by remember { mutableStateOf("") }
    var hasSelfie by remember { mutableStateOf(false) }
    val selfieLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        hasSelfie = bitmap != null
    }
    
    Column(Modifier.fillMaxSize().background(Bg).padding(20.dp)) {
        Text("KYC Verification - Safety", color = TextMain, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = nid,
            onValueChange = { nid = it },
            label = { Text("NID Number") },
            modifier = Modifier.fillMaxWidth().background(Surface, RoundedCornerShape(17.dp)),
            shape = RoundedCornerShape(17.dp)
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { selfieLauncher.launch(null) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Surface2)
        ) {
            Text(if (hasSelfie) "Retake Live Selfie ✓" else "Take Live Selfie (Required for Safety)")
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {},
            enabled = nid.isNotEmpty() && hasSelfie,
            modifier = Modifier.fillMaxWidth().height(54.dp),
            shape = RoundedCornerShape(17.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text("Submit KYC", color = Color(0xFF04140D), fontWeight = FontWeight.ExtraBold)
        }
    }
}
