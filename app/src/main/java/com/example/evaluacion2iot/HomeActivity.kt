package com.example.evaluacion2iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cambiarPantallaRealizarViaje: Button = findViewById(R.id.btnRealizarViaje)
        cambiarPantallaRealizarViaje.setOnClickListener {
            val intent = Intent(this, RealizarViajeActivity::class.java)
            startActivity(intent)
        }
        val cambiarPantallaHistorial: Button = findViewById(R.id.btnHistorial)
        cambiarPantallaHistorial.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
        }
        val cambiarPantallaFavoritos: Button = findViewById(R.id.btnFavoritos)
        cambiarPantallaFavoritos.setOnClickListener {
            val intent = Intent(this, FavoritosActivity::class.java)
            startActivity(intent)
        }
        val cambiarPantallaVolver: Button = findViewById(R.id.btnVolver)
        cambiarPantallaVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}