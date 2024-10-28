package com.example.evaluacion2iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emailField: EditText = findViewById(R.id.email)
        val passwordField: EditText = findViewById(R.id.password)
        val cambiarPantallaIniciar: Button = findViewById(R.id.btnIniciar)
        cambiarPantallaIniciar.setOnClickListener {
            try {
                val email = emailField.text.toString().trim()
                val password = passwordField.text.toString().trim()

                if (email.isEmpty() || password.isEmpty()) {
                    throw  IllegalArgumentException("Tiene que ingresar los campos")
                }
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}