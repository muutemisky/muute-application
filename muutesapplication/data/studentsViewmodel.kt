package com.example.muutesapplication.data
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.muutesapplication.models.Student
import com.example.muutesapplication.navigation.ROUTE_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StudentViewModel(var navController: NavController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveStudent(studentName: String, studentClasss: String,studentTime:String) {
        val id = System.currentTimeMillis().toString()
        val studentdata = Student(studentName, studentClasss, id,studentTime )
        val studentRef = FirebaseDatabase.getInstance().getReference().child("Student/$id")
        progress.show()
        studentRef.setValue(studentdata).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewStudents(
        student: MutableState<Student>,
        students: SnapshotStateList<Student>): SnapshotStateList<Student> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Student")
//        progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                 progress.dismiss()
                students.clear()
                // emptyProductsListState.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Student::class.java)
                    student.value = value!!
                    students.add(value)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return students
    }
//fun viewBooks(
//        book: MutableState<Books>,
//        books: SnapshotStateList<Books>): SnapshotStateList<Books> {
//        var ref = FirebaseDatabase.getInstance().getReference().child("books")
//
////        progress.show()
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
////                progress.dismiss()
//                books.clear()
//                for (snap in snapshot.children) {
//                    val value = snap.getValue(Books::class.java)
//                    book.value = value!!
//                    books.add(value)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        return books
//    }
    fun deleteStudent(id: String) {
        val delRef = FirebaseDatabase.getInstance().getReference()
            .child("Student/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Student deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateStudent(name: String, classs: String, time:String, id: String) {
        val updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Student/$id")
        progress.show()
        val updateData = Student(name, classs , time, id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

