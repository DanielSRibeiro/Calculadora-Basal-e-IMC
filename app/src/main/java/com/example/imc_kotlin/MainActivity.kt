package com.example.imc_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var buttonIMC: Button
    lateinit var buttonNcd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonIMC = findViewById(R.id.buttonIMC)
        buttonNcd = findViewById(R.id.buttonNcd)

        buttonIMC.setOnClickListener {
            var intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }
        buttonNcd.setOnClickListener {
            var intent = Intent(this, NecessidadesCaloricasActivity::class.java)
            startActivity(intent)
        }
    }
}