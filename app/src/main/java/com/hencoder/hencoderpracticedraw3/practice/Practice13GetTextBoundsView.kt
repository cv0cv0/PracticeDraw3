package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style=Paint.Style.STROKE
        strokeWidth=20f
        color=Color.parseColor("#E91E63")
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize=160f }

    private val text1 = "A"
    private val text2 = "a"
    private val text3 = "J"
    private val text4 = "j"
    private val text5 = "Â"
    private val text6 = "â"
    private val top = 200f
    private val bottom = 400f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(50f, top, width - 50f, bottom, paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        val middle = (top + bottom) / 2
        canvas.drawText(text1, 100f, middle, paint2)
        canvas.drawText(text2, 200f, middle, paint2)
        canvas.drawText(text3, 300f, middle, paint2)
        canvas.drawText(text4, 400f, middle, paint2)
        canvas.drawText(text5, 500f, middle, paint2)
        canvas.drawText(text6, 600f, middle, paint2)
    }
}