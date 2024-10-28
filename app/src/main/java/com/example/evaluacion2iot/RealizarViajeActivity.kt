package com.example.evaluacion2iot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RealizarViajeActivity : AppCompatActivity() {
    private lateinit var ubicacion1: String
    private lateinit var ubicacion2: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.realizar_viaje)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adondevas: EditText = findViewById(R.id.adondevas)
        val sharedPref = getSharedPreferences("Mis ubicaciones", Context.MODE_PRIVATE)
        ubicacion1 = sharedPref.getString("ubicacion1", "Inacap") ?: "Inacap"
        ubicacion2 = sharedPref.getString("ubicacion2", "Casa") ?: "Casa"



        val btnIniciarViaje: Button = findViewById(R.id.btnIniciarViaje)
        btnIniciarViaje.setOnClickListener {
            val editor = sharedPref.edit()
            editor.putString("ubicacion1", adondevas.text.toString())
            editor.putString("ubicacion2", ubicacion2)
            editor.apply()
            Toast.makeText(this, "Viaje en proceso", Toast.LENGTH_SHORT).show()
        }
        val btnVolverAtras: Button = findViewById(R.id.btnVolverHome)
        btnVolverAtras.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}