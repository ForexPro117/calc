package com.example.calc

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import android.util.TypedValue
import android.view.View
import java.util.Vector

class PaintView(context: Context?) : View(context) {
    private var otherPaint: Paint
    private var linePaint: Paint
    private var textPaint: Paint

    init {
        textPaint = Paint(Paint.LINEAR_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.WHITE
        textPaint.textSize = 24.toPx

        linePaint = Paint()
//        linePaint.style = Paint.Style.FILL
        linePaint.color = Color.parseColor("#000000")
        linePaint.strokeWidth = 3f
        linePaint.style = Paint.Style.STROKE

        otherPaint = Paint()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /*canvas.drawPaint(outerPaint)
        canvas.drawColor(Color.CYAN)
        otherPaint.color = Color.WHITE
        otherPaint.style = Paint.Style.FILL
        canvas.drawVertices()
        canvas.drawRect(
            (
                    left + (right - left) / 3).toFloat(),
            (
                    top + (bottom - top) / 3).toFloat(),
            (
                    right - (right - left) / 3).toFloat(),
            (
                    bottom - (bottom - top) / 3).toFloat(),
                    otherPaint
        )
        otherPaint.color = Color.GREEN
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 100.toPx, otherPaint)
        canvas.drawText(
            "Geeks for Geeks",
            (width * 0.3).toFloat(),
            (height * 0.8).toFloat(),
            textPaint
        )*/
        canvas.drawColor(Color.WHITE)
//        canvas.drawLine(0f.toPx, 0f.toPx, 360f.toPx, 360f.toPx, linePaint)
//        canvas.drawLine(360f.toPx, 0f.toPx, 0f.toPx, 360f.toPx, linePaint)
        var linesCount = 20
        var lines = FloatArray(20 * 4 * 2)
        var index = 0
        for (i in 0 until linesCount) {
            lines[index++] = 30.toPx * i   //x1
            lines[index++] = 0f            //y1
            lines[index++] = 30.toPx * i   //x2
            lines[index++] = 600.toPx     //y2
        }

        for (i in 0 until linesCount) {
            lines[index++] = 0f            //x1
            lines[index++] = 30.toPx * i   //y1
            lines[index++] = 410.toPx     //x2
            lines[index++] = 30.toPx * i   //y2
        }

        canvas.drawLines(lines, linePaint)

        var path = Path()
        path.moveTo(0.toPx, 120.toPx);

        repeat(10) { _ ->
            path.rQuadTo((Math.PI / 2).toPx * 10, (-90).toPx, Math.PI.toPx * 10, 0.toPx);
            path.rQuadTo((Math.PI / 2).toPx * 10, 90.toPx, Math.PI.toPx * 10, 0.toPx);
        }

        linePaint.color = Color.BLUE
        linePaint.strokeWidth = 6f
        canvas.drawPath(path, linePaint)
    }

    private val Number.toPx
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics
        )

}