package com.example.muutesapplication.ui.theme.screens.attendance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//import com.example.attendance.attendanceapplication.navigation.ROUTE_UPDATE_STUDENT
import com.example.muutesapplication.data.StudentViewModel
import com.example.muutesapplication.models.Student
import com.example.muutesapplication.navigation.ROUTE_UPDATE_STUDENT

//import com.example.brabas.models.Product
//import com.example.brabas.navigate.ROUTE_UPDATE_PRODUCT
//import com.example.morningmvvm.data.ProductViewModel

//import com.example.morningmvvm.data.ProductViewModel
//import com.example.morningmvvm.models.Product
//import com.example.brabas.navigation.ROUTE_UPDATE_PRODUCT




@Composable
fun ViewStudentScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val studentRepository = StudentViewModel(navController, context)
        val emptyStudentState = remember { mutableStateOf(Student("","","","")) }
        val emptyStudentsListState = remember { mutableStateListOf<Student>() }

        val students = studentRepository.viewStudents(emptyStudentState, emptyStudentsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All Students",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(students){
                    StudentItem(
                        name = it.name,
                        classs = it.classs,
                        time = it.time,
                        id = it.id,
                        navController = navController,
                        studentRepository = studentRepository
                    )
                }
            }
        }
    }

}



@Composable
fun StudentItem(name:String, classs:String, time:String, id:String,
                navController:NavHostController, studentRepository: StudentViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = classs)
        Text(text = time)
        Button(onClick = {
            studentRepository.deleteStudent(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_STUDENT +"/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun View() {
    ViewStudentScreen(rememberNavController())

}






