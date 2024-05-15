//
//package com.example.muutesapplication.ui.theme.screens.dashboard
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material.Button
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.unit.it
//
//@Composable
//fun Dashboard() {
//    var userName by remember { mutableStateOf(TextFieldValue()) }
//    var password by remember { mutableStateOf(TextFieldValue()) }
//    var loggedIn by remember { mutableStateOf(false) }
//
//    if (loggedIn) {
//        // Dashboard content
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Welcome, ${userName.text}!", fontSize = 24.sp)
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { /*TODO*/ }) {
//                Text("View Attendance")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { /*TODO*/ }) {
//                Text("Edit Profile")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { /*TODO*/ }) {
//                Text("Logout")
//            }
//        }
//    } else {
//        // Login screen
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            BasicTextField(
//                value = userName,
//                onValueChange = { userName = it },
//                placeholder = { Text("Username") }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            BasicTextField(
//                value = password,
//                onValueChange = { password = it },
//                placeholder = { Text("Password") }
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = { loggedIn = true }) {
//                Text("Login")
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewDashboard() {
//    Dashboard()
//}
