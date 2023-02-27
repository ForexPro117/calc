package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
    }

    fun addCalc(view: View) {
        val btn = view as Button
        System.err.println(btn.text)
        Log.e("HNEEE", btn.text as String)
    }
}