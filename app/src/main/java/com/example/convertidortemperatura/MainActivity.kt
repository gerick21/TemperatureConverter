package com.example.convertidortemperatura
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/*
Authors:
Gerick Vargas Camacho
Andrés González Romero
* */

class MainActivity : AppCompatActivity() {

    private var currentTemperature: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val textViewTemperature = findViewById<TextView>(R.id.textViewTemperature)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButtonFtoC = findViewById<RadioButton>(R.id.radioButton)
        val radioButtonCtoF = findViewById<RadioButton>(R.id.radioButton2)
        val convertirButton = findViewById<Button>(R.id.convertirButton)
        val buttonAbout = findViewById<Button>(R.id.buttonAbout)

        buttonMinus.setOnClickListener {
            currentTemperature -= 1
            textViewTemperature.text = currentTemperature.toString()
        }

        buttonPlus.setOnClickListener {
            currentTemperature += 1
            textViewTemperature.text = currentTemperature.toString()
        }

        convertirButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId == -1) {
                Toast.makeText(this, "Seleccione el tipo de conversión", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result: Double
            val resultText: String
            if (selectedRadioButtonId == radioButtonFtoC.id) {
                result = (currentTemperature - 32) * 5 / 9
                resultText = String.format("%.2f grados Fahrenheit equivalen a %.2f grados Celsius", currentTemperature, result)
            } else {
                result = (currentTemperature * 9 / 5) + 32
                resultText = String.format("%.2f grados Celsius equivalen a %.2f grados Fahrenheit", currentTemperature, result)
            }

            // Launch ResultActivity with the result
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("conversionResult", resultText)
            startActivity(intent)
        }

        buttonAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
