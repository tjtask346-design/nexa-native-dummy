package com.nexa.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nexa.app.ui.screens.*
import com.nexa.app.ui.theme.NexaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexaTheme {
                val nav = rememberNavController()
                var userEmail by remember { mutableStateOf("") }
                
                NavHost(navController = nav, startDestination = "splash") {
                    composable("splash") { SplashScreen(onFinish = { hasUser ->
                        if (hasUser) nav.navigate("pin_login") { popUpTo("splash"){inclusive=true} }
                        else nav.navigate("login") { popUpTo("splash"){inclusive=true} }
                    }) }
                    composable("login") { 
                        LoginScreen(
                            onLogin = { email -> 
                                userEmail = email
                                nav.navigate("pin_login")
                            },
                            onSignupClick = { nav.navigate("signup") }
                        ) 
                    }
                    composable("signup") {
                        SignupScreen(
                            onSignup = { email ->
                                userEmail = email
                                nav.navigate("pin_setup")
                            },
                            onLoginClick = { nav.navigate("login") }
                        )
                    }
                    composable("pin_setup") { PinScreen(mode = "setup", onSuccess = { nav.navigate("home"){popUpTo(0){inclusive=true}} }) }
                    composable("pin_login") { PinScreen(mode = "login", onSuccess = { nav.navigate("home"){popUpTo(0){inclusive=true}} }) }
                    composable("home") { HomeScreen(nav) }
                    composable("deposit") { DepositScreen(nav) }
                    composable("withdraw") { WithdrawScreen(nav) }
                    composable("myqr") { MyQrScreen(nav) }
                    composable("scan") { ScanScreen(nav) }
                    composable("history") { HistoryScreen(nav) }
                    composable("profile") { ProfileScreen(nav) }
                }
            }
        }
    }
}
