package com.example.muutesapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.muutesapplication.ui.theme.screens.attendance.AddStudentScreen
import com.example.muutesapplication.ui.theme.screens.attendance.UpdateStudentScreen
import com.example.muutesapplication.ui.theme.screens.attendance.ViewStudentScreen
import com.example.muutesapplication.ui.theme.screens.home.HomeScreen
import com.example.muutesapplication.ui.theme.screens.login.LoginScreen
import com.example.muutesapplication.ui.theme.screens.signup.SignUpScreen
import java.lang.reflect.Modifier

@Composable
fun AppNavHost(modifier: Modifier= Modifier(),
               navController:NavHostController= rememberNavController(),
               startDestination :String= ROUTE_SIGN_UP
) {
    NavHost(
        navController = navController,

        startDestination = startDestination
    ) { composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_SIGN_UP) {
            SignUpScreen(navController)
        }
        composable(ROUTE_ADD_STUDENT) {
            AddStudentScreen(navController)
        }
        composable("$ROUTE_UPDATE_STUDENT/{id}") { passedData ->
            UpdateStudentScreen(navController ,passedData.arguments?.getString("id")!!)
        }

//        composable(ROUTE_DASHBOARD) {
//            DashboardScreen(navController)
//        }
        composable(ROUTE_VIEW_STUDENT) {
            ViewStudentScreen(navController)

        }
    }
}

