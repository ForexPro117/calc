package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CalcActivity : AppCompatActivity() {

    var calcView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        calcView = findViewById(R.id.calcTextView)
    }

    fun addNum(view: View) {
        checkErrors()
        val btn = view as Button
        var text = calcView?.text.toString()
        if (text.length < 100)
            calcView?.text = calcView?.text.toString().plus(btn.text.toString())
    }


    fun addOP(view: View) {
        checkErrors()
        val btn = view as Button
        var text = calcView?.text.toString()
        var regex = Regex("[+\\-*/]")
        if (regex.containsMatchIn(text))
            calcView?.text = text.replace(regex, btn.text.toString())
        else if (text.length in 1..99)
            calcView?.text = calcView?.text.toString().plus(btn.text.toString())
    }

    fun clearTextView(view: View) {
        calcView?.text = ""
    }

    fun delTextChar(view: View) {
        calcView?.text = calcView?.text.toString().dropLast(1)
    }

    fun addPoint(view: View) {
        calcView?.text = calcView?.text.toString().plus(".")
    }

    fun checkNumbers(view: View) {
        var text = calcView?.text.toString()
        var regex = Regex("(\\d+\\.?\\d*)([+\\-*/])(\\d+\\.?\\d*)")
        var result = regex.find(text)

        if (regex.containsMatchIn(text)) {
            var (num1, operator, num2) = result!!.destructured
            try {
                var el1 = num1.toDouble()
                var el2 = num2.toDouble()
                var result = calculate(el1, el2, operator).toString()
                if (Regex("\\.0$").containsMatchIn(result))
                    result = result.dropLast(2)
                calcView?.text = result

            } catch (e: Exception) {
                println(e)//error
            }
        } else {
            println("sdsd")//error
        }
    }


    private fun calculate(num1: Double, num2: Double, operator: String): Double {
        return when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> 0.0
        }
    }

    private fun checkErrors(){
        if(Regex("NaN|Infinity").containsMatchIn(calcView?.text.toString()))
            calcView?.text = ""
    }

}