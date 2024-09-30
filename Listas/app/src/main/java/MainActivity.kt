package com.example.userlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        val userList = mutableListOf<User>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etSurname = findViewById<EditText>(R.id.etSurname)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etHobby = findViewById<EditText>(R.id.etHobby)
        val btnAddUser = findViewById<Button>(R.id.btnAddUser)
        val btnViewUsers = findViewById<Button>(R.id.btnViewUsers)

        btnAddUser.setOnClickListener {
            val name = etName.text.toString()
            val surname = etSurname.text.toString()
            val phone = etPhone.text.toString()
            val hobby = etHobby.text.toString()

            if (name.isEmpty() || surname.isEmpty() || phone.isEmpty() || hobby.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, surname, phone, hobby)
                userList.add(user)
                Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show()

                // Limpiar los campos
                etName.text.clear()
                etSurname.text.clear()
                etPhone.text.clear()
                etHobby.text.clear()
            }
        }

        btnViewUsers.setOnClickListener {
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }
}

data class User(val name: String, val surname: String, val phone: String, val hobby: String)
