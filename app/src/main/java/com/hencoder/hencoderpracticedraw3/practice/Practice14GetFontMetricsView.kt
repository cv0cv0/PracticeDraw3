package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice14GetFontMetricsView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 20f
        color = Color.parseColor("#E91E63")
    }
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 160f }

    private val texts = arrayOf("A", "a", "J", "j", "Â", "â")
    private val offset by lazy(LazyThreadSafetyMode.NONE) {
        val metrics = paint2.fontMetrics
        -(metrics.ascent + metrics.descent) / 2f
    }

    private val top = 200f
    private val bottom = 400f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(50f, top, width - 50f, bottom, paint1)

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐
        val middle = (top + bottom) / 2
        repeat(texts.size) {
            canvas.drawText(texts[it], (it + 1) * 100f, middle + offset, paint2)
        }
    }
}
