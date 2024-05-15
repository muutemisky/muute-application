package com.example.muutesapplication.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.muutesapplication.R
//import com.example.attendance.attendanceapplication.navigation.ROUTE_ADD_STUDENT
//import com.example.miskysapplication.navigation.ROUTE_ADD_Student
//import com.example.attendance.attendanceapplication.navigation.ROUTE_VIEW_STUDENT
import com.example.muutesapplication.navigation.ROUTE_ADD_STUDENT
import com.example.muutesapplication.navigation.ROUTE_VIEW_STUDENT

//import com.example.miskysapplication.navigation.ROUTE_ABOUT

@Composable
fun HomeScreen(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()) {



        Image(painter = painterResource(id =R.drawable.i), contentDescription ="Background Image" ,
            contentScale = ContentScale.FillBounds, modifier = Modifier.matchParentSize())

    }


    Column(modifier = Modifier
        .fillMaxSize(),
        //.background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally) {


        var context= LocalContext.current
        //  var productdata=productviewmodel(navController,context)

        Text(text = "STUDENT ATTENDANCE SYSTEM",
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_ADD_STUDENT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Add Student")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_STUDENT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Student")
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
