package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView

class GraphActivity : AppCompatActivity() {

    private lateinit var layout: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        layout = findViewById(R.id.graphLayout)

        val paintView = PaintView(this)
        layout.addView(paintView)
    }
}