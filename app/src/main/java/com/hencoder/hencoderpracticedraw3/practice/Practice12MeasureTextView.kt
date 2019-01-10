package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice12MeasureTextView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 60f }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 120f
        color = Color.parseColor("#E91E63")
    }

    private val text1 = "三个月内你胖了"
    private val text2 = "4.5"
    private val text3 = "公斤"

    private val text1Width = paint1.measureText(text1)
    private val text2Width = paint2.measureText(text2)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制
        canvas.drawText(text1, 50f, 200f, paint1)
        canvas.drawText(text2, 50f + text1Width, 200f, paint2)
        canvas.drawText(text3, 50f + text1Width + text2Width, 200f, paint1)
    }
}
