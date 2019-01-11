package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 20f
        color = Color.parseColor("#E91E63")
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 160f }

    private val texts = arrayOf("A", "a", "J", "j", "Â", "â")
    private val offsets = FloatArray(texts.size)

    private val top = 200f
    private val bottom = 400f

    init {
        val rect = Rect()
        repeat(texts.size) {
            paint2.getTextBounds(texts[it], 0, texts[it].length, rect)
            offsets[it] = -(rect.top + rect.bottom) / 2f
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(50f, top, width - 50f, bottom, paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        val middle = (top + bottom) / 2
        repeat(texts.size) {
            canvas.drawText(texts[it], (it + 1) * 100f, middle + offsets[it], paint2)
        }
    }
}