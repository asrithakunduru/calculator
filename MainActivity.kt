package com.example.calculator
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtxt1: EditText = findViewById(R.id.editTextNumber)
        val edtxt2: EditText = findViewById(R.id.editTextNumber2)
        val resultTV: TextView = findViewById(R.id.textView3)

        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonSubtract: Button = findViewById(R.id.buttonSubtract)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)

        buttonAdd.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "add")
        }

        buttonSubtract.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "subtract")
        }

        buttonMultiply.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "multiply")
        }

        buttonDivide.setOnClickListener {
            performOperation(edtxt1, edtxt2, resultTV, "divide")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun performOperation(edtxt1: EditText, edtxt2: EditText, resultTV: TextView, operation: String) {
        val x = edtxt1.text.toString().toDoubleOrNull()
        val y = edtxt2.text.toString().toDoubleOrNull()

        if (x == null || y == null) {
            resultTV.text = "Invalid input"
            return
        }

        val result = when (operation) {
            "add" -> sum(x, y)
            "subtract" -> subtract(x, y)
            "multiply" -> multiply(x, y)
            "divide" -> divide(x, y)
            else -> 0.0
        }
        resultTV.text = result.toString()
    }

    private fun sum(a: Double, b: Double): Double {
        return a + b
    }

    private fun subtract(a: Double, b: Double): Double {
        return a - b
    }

    private fun multiply(a: Double, b: Double): Double {
        return a * b
    }

    private fun divide(a: Double, b: Double): Double {
        return if (b != 0.0) a / b else Double.NaN
    }
}
