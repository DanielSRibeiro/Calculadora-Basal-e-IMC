package com.example.imc_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputLayout

class IMCActivity : AppCompatActivity() {

    lateinit var editTextAlt: EditText
    lateinit var editTextPeso: EditText
    lateinit var buttonCalcular: Button
    lateinit var spinnerSexo: Spinner
    lateinit var textInputLayoutPeso: TextInputLayout
    lateinit var textInputLayoutAlt: TextInputLayout
    var erro = false
    var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_m_c)

        editTextAlt = findViewById(R.id.editTextAltIMC)
        editTextPeso = findViewById(R.id.editTextPesoIMC)
        buttonCalcular = findViewById(R.id.buttonCalcularIMC)
        textInputLayoutPeso = findViewById(R.id.inputLayoutPeso)
        textInputLayoutAlt = findViewById(R.id.inputLayoutAlt)

        buttonCalcular.setOnClickListener {
            ValidaçãoFormulario()

            if(erro == false) {
                var peso = editTextPeso.text.toString().toDouble()
                var altura = editTextAlt.text.toString().toDouble()

                altura = altura/100

                var imc = peso/Math.pow(altura, 2.0)
                var resulta:String =""

                if(imc <= 18.5){
                    resulta = "Abaixo do Peso"
                }else if(imc <= 24.9){
                    resulta = "Peso Normal"
                }else if(imc <= 29.9){
                    resulta = "Sobrepeso"
                }else if(imc <= 34.9){
                    resulta = "Obesidade Grau 1"
                }else if(imc <= 39.9){
                    resulta = "Obesidade Grau 2"
                }else{
                    resulta = "Mórbida"
                }

                val toast = Toast.makeText(this, "Seu IMC é : "+ String.format("%.2f", imc)+"\n Categoria: "+resulta, Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }

    private fun ValidaçãoFormulario() : Boolean {
            erro = false
        if(editTextAlt.text.isEmpty()){
            textInputLayoutAlt.error = "É Necessário colocar a sua Altura!!!"
            erro = true
        }
        else{
            textInputLayoutAlt.error = ""
        }

        if(editTextPeso.text.isEmpty()){
            textInputLayoutPeso.error = "É Necessário colocar o seu Peso!!!"
            erro = true
        }
        else{
            textInputLayoutPeso.error = ""
        }

        return erro
    }
}