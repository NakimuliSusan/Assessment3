package dev.pinky.assessment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CalculatorActivity : AppCompatActivity() {
    lateinit var btnAdd : Button
    lateinit var btnSubtract :Button
    lateinit var btnDivision : Button
    lateinit var btnModulus : Button
    lateinit var tilNumber1 : TextInputLayout
    lateinit var tilNumber2 : TextInputLayout
    lateinit var etNumber1 : TextInputEditText
    lateinit var etNumber2 : TextInputEditText
    lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivision = findViewById(R.id.btnDivision)
        btnModulus = findViewById(R.id.btnModulus)
        tilNumber1 = findViewById(R.id.tilNumber1)
        tilNumber2 = findViewById(R.id.tilNumber2)
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        tvResult = findViewById(R.id.tvResult)

        btnAdd.setOnClickListener {
            tvResult.text = ""
            val int_Number1 = etNumber1.text.toString()
            val int_Number2 = etNumber2.text.toString()

            if (int_Number1.isBlank()) {
                tilNumber1.error = "A number is required"
            }
            else if (int_Number2 .isBlank()) {
                tilNumber2.error = "A number is required"
            }
            else {
                add(int_Number1.toDouble(), int_Number2.toDouble())
            }
        }
        btnDivision.setOnClickListener {
            tvResult.text = ""
            val int_Number1 = etNumber1.text.toString()
            val int_Number2 = etNumber2.text.toString()

            if (int_Number1.isBlank()) {
                tilNumber1.error = "A number is required"
            }
            else if (int_Number2.isBlank()){
                    tilNumber2.error = "A number is required"
                }
            else {
            division(int_Number1.toDouble(), int_Number2.toDouble())
        }

        }
        btnModulus.setOnClickListener {
            tvResult.text = ""
            val int_Number1 = etNumber1.text.toString()
            val int_Number2 = etNumber2.text.toString()

            if (int_Number1.isBlank()) {
                tilNumber1.error = "A number is required"
            }
            else if(int_Number2. isBlank()){
                    tilNumber2.error = "A number is required"
            }
            else {
                modulus(int_Number1.toDouble(), int_Number2.toDouble())

            }
        }
        btnSubtract.setOnClickListener {
            val int_Number1 = etNumber1.text.toString()
            val int_Number2 = etNumber2.text.toString()

            if (int_Number1.isBlank()) {
                tilNumber1.error = "A number is required"
            }
            else if (int_Number2.isBlank()) {
                tilNumber2.error = "A number is required"
            }
            else {
                subtract(int_Number1.toDouble(), int_Number2.toDouble())
            }
        }
    }
    fun add (int_Number1:Double, int_Number2:Double) {
        val sum = int_Number1 + int_Number2
        tvResult.text = sum.toString()
    }
    fun subtract (int_Number1: Double,int_Number2: Double){
        val difference = int_Number1 - int_Number2
        tvResult.text = difference.toString()
    }
    fun division (int_Number1:Double,int_Number2:Double) {
        val result = int_Number1 / int_Number2
        tvResult.text = result .toString()
    }
    fun modulus (int_Number1:Double,int_Number2:Double) {
        val outcome = int_Number1 % int_Number2
        tvResult.text = outcome.toString()
    }
}