package com.example.imc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.IntegerRes
import com.google.android.material.textfield.TextInputLayout

class NecessidadesCaloricasActivity : AppCompatActivity() {

    lateinit var editTextIdd: EditText
    lateinit var editTextAlt: EditText
    lateinit var editTextPeso: EditText
    lateinit var buttonCalcular: Button
    lateinit var textInputLayoutPeso: TextInputLayout
    lateinit var textInputLayoutAlt: TextInputLayout
    lateinit var textInputLayoutIdade: TextInputLayout
    lateinit var radioF: RadioButton
    lateinit var radioM: RadioButton

    var erro = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_necessidades_caloricas)

        editTextIdd = findViewById(R.id.editTextIdd)
        editTextAlt = findViewById(R.id.editTextAlt)
        editTextPeso = findViewById(R.id.editTextPeso)
        buttonCalcular = findViewById(R.id.buttonCalcularNcd)
        textInputLayoutPeso = findViewById(R.id.inputLayoutPesoN)
        textInputLayoutIdade = findViewById(R.id.inputLayoutIdadeN)
        textInputLayoutAlt = findViewById(R.id.inputLayoutAlturaN)
        radioF = findViewById(R.id.radioF)
        radioM = findViewById(R.id.radioM)

        buttonCalcular.setOnClickListener {
            ValidaçãoFormulario()

            if(erro == false){
                val idade = editTextIdd.text.toString().toDouble()
                val altura = editTextAlt.text.toString().toDouble()
                val peso = editTextPeso.text.toString().toDouble()

                var resutado:Double

                if(radioF.isChecked){
                    resutado = 665+ (9.6 * peso) + (1.8 * altura) - (4.7 * idade)
                }else{
                    resutado = 66+ (13.7 * peso) + (5 * altura) - (6.8 * idade)
                }

                val toast = Toast.makeText(this, "Sua Necessidade Calórica diária é "+
                        String.format("%.2f", resutado)+" kcal", Toast.LENGTH_LONG)
                toast.show()
            }

        }
    }

    private fun ValidaçãoFormulario() : Boolean {
        erro = false

        if(editTextIdd.text.isEmpty()){
            textInputLayoutIdade.error = "É Necessário colocar o sua Idade!!!"
            erro = true
        }else{
            textInputLayoutIdade.error = ""
        }
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