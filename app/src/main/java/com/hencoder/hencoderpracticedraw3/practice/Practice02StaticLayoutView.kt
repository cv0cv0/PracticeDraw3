package com.hencoder.hencoderpracticedraw3.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class Practice02StaticLayoutView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply { textSize = 60f }
    private val text = "Hello\nHenCoder"

    private val staticLayout = StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.save()
        canvas.translate(50f, 40f)
        staticLayout.draw(canvas)
        canvas.restore()
    }
}
