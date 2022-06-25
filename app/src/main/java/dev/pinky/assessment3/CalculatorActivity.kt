package dev.pinky.assessment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.pinky.assessment3.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleClicks()
    }
    fun handleClicks() {
            binding.btnAdd.setOnClickListener {
                add(obtainInputs())

            }
            binding.btnSubtract.setOnClickListener {
                    subtract(obtainInputs())
            }
            binding.btnModulus.setOnClickListener {
                    modulus(obtainInputs())
            }
            binding.btnDivision.setOnClickListener {
                division(obtainInputs())
            }

    }
    data class Inputs (var num1: Double, var num2: Double)

    fun obtainInputs():Inputs? {
        binding.tilNumber1.error = null
        binding.tilNumber2.error = null
        val num1 = binding.etNumber1.text.toString()
        val num2 = binding.etNumber2.text.toString()
        var error = false

        if (num1.isBlank()) {
            binding.tilNumber1.error = "Number 1 is Required"
            error = true
        }
        if (num2 .isBlank()) {
            binding.tilNumber2.error = "Number 2 is required"
            error = true
        }
        if(!error) {
            return Inputs(num1.toDouble(), num2.toDouble())
        }
        return null
    }
    fun add (inputs:Inputs?) {
        if (inputs != null) {
            displayResults(inputs.num1 + inputs.num2)
        }
    }
    fun subtract (inputs: Inputs?) {
        if (inputs != null) {
            displayResults(inputs.num1 - inputs.num2)
        }
    }
    fun division (inputs:Inputs?) {
        if (inputs != null) {
            displayResults(inputs.num1 / inputs.num2)
        }
    }
    fun modulus (inputs:Inputs?) {
        if (inputs != null) {
            displayResults(inputs.num1 % inputs.num2)
    }
    }
    fun displayResults (outcome: Double) {
        binding.tvResult.text = outcome.toString()
    }
}