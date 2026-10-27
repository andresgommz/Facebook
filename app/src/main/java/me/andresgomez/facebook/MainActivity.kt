package me.andresgomez.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.andresgomez.facebook.ui.screens.FacebookLoginScreen
import me.andresgomez.facebook.ui.screens.FacebookRegisterScreen
import me.andresgomez.facebook.ui.screens.FeedScreen
import me.andresgomez.facebook.ui.screens.ForgotPassword

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val myNavController = rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = Routes.LOGIN,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = Routes.LOGIN) {
                    FacebookLoginScreen(
                        onClickRegister = {
                            myNavController.navigate(Routes.REGISTER)
                        },
                        onClickLogin = {
                            myNavController.navigate(Routes.FEED) {
                                popUpTo(Routes.LOGIN) {
                                    inclusive = true
                                }
                            }
                        },
                        onClickForgotPassword = {
                            myNavController.navigate(Routes.FORGOT_PASSWORD)
                        }
                    )
                }
                composable(route = Routes.REGISTER) {
                    FacebookRegisterScreen(onClickBack = {
                        myNavController.popBackStack()
                    })
                }
                composable(route = Routes.FORGOT_PASSWORD) {
                    ForgotPassword(onBackClick = {
                        myNavController.popBackStack()
                    })
                }
                composable(route = Routes.FEED) {
                    FeedScreen()
                }
            }
        }
    }
}
