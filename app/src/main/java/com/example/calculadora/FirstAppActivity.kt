package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainFirstAppMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSum = findViewById<AppCompatButton>(R.id.btnSum)
        val btnRes = findViewById<AppCompatButton>(R.id.btnRes)
        val btnMul = findViewById<AppCompatButton>(R.id.btnMul)
        val btnDiv = findViewById<AppCompatButton>(R.id.btnDiv)

        val number1 = findViewById<AppCompatEditText>(R.id.number1)
        val number2 = findViewById<AppCompatEditText>(R.id.number2)

        btnSum.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 + num2
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", "El resultado de la suma es: $result")
                }
                startActivity(intent)
            } else {
                Log.e("FirstAppActivity", "Invalid input: num1 = $num1, num2 = $num2")
            }
        }

        btnRes.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", "El resultado de la resta es: $result")
                }
                startActivity(intent)
            } else {
                Log.e("FirstAppActivity", "Invalid input: num1 = $num1, num2 = $num2")
            }
        }

        btnMul.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 * num2
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", "El resultado de la multiplicación es: $result")
                }
                startActivity(intent)
            } else {
                Log.e("FirstAppActivity", "Invalid input: num1 = $num1, num2 = $num2")
            }
        }

        btnDiv.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 / num2
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", "El resultado de la división es: $result")
                }
                startActivity(intent)
            } else {
                Log.e("FirstAppActivity", "Invalid input: num1 = $num1, num2 = $num2")
            }
        }
    }
}
