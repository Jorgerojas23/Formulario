package com.example.userlist

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class UserListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        listView = findViewById(R.id.lvUsers)

        // Llenar el ListView con los datos de los usuarios
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            MainActivity.userList.map { "${it.name} ${it.surname} - ${it.phone} - ${it.hobby}" }
        )

        listView.adapter = adapter

        // Manejar la eliminación y edición de usuarios
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedUser = MainActivity.userList[position]

            val options = arrayOf("Editar", "Eliminar")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Selecciona una opción")
            builder.setItems(options) { _, which ->
                when (which) {
                    0 -> editUser(position)
                    1 -> deleteUser(position)
                }
            }
            builder.show()
        }
    }

    private fun editUser(position: Int) {
        // Aquí puedes implementar la lógica para editar el usuario
        Toast.makeText(this, "Función de editar aún no implementada", Toast.LENGTH_SHORT).show()
    }

    private fun deleteUser(position: Int) {
        MainActivity.userList.removeAt(position)
        adapter.notifyDataSetChanged()
        Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show()
    }
}
