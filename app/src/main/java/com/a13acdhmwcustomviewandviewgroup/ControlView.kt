package com.a13acdhmwcustomviewandviewgroup

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

private const val MULTIPLIER_MAIN_CIRCLE_RADIUS = 0.8F

class ControlView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrs: Int = 0
) : View(context, attributeSet, defAttrs) {

    private data class Point(val x: Float, val y: Float)

    private val selectionsCount = 4
    var activeSelection = 0    //маркер для відображення точки навпроти числа
        set(value) {
            field = value
            invalidate()
        }

    private var width = 0F
    private var height = 0F

    private val textPaint by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.FILL_AND_STROKE
            textAlign = Paint.Align.CENTER
            textSize = numbersTextSize

        }
    }
    private var circlePaint = Paint().apply {
        color = Color.GREEN
    }

    private var radiusMainCircle: Float = 0F
    private var radiusPointerCircle: Float = 0F

    private var externalMarginMainCircle = 0F
    private var internalMarginToMainCircle = 0F

    private var numbersTextSize = 0F

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()

        calculateItemsSize()
    }

    private fun calculateItemsSize() {
        radiusMainCircle = (width.coerceAtMost(height) / 2.0F * MULTIPLIER_MAIN_CIRCLE_RADIUS)
        radiusPointerCircle = radiusMainCircle * 0.08F
        externalMarginMainCircle = radiusMainCircle * 0.1F
        internalMarginToMainCircle = radiusMainCircle * 0.2F
        numbersTextSize = radiusMainCircle * 0.15F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            drawMainCircle(this)
            drawNumbers(this)
            drawPointerCircle(this)
        }
    }

    private fun drawMainCircle(canvas: Canvas) {
        canvas.drawCircle(width / 2, height / 2, radiusMainCircle, circlePaint)
    }

    private fun drawNumbers(canvas: Canvas) {
        val numbersRadius = radiusMainCircle + externalMarginMainCircle
        for (i in 0 until selectionsCount) {
            val point = calculatePointForPosition(i, numbersRadius)
            canvas.drawText(i.toString(), point.x, point.y, textPaint)
        }
    }

    private fun drawPointerCircle(canvas: Canvas) {
        val markerRadius = radiusMainCircle - internalMarginToMainCircle
        val point = calculatePointForPosition(activeSelection, markerRadius)
        canvas.drawCircle(point.x, point.y, radiusPointerCircle, textPaint)
    }

    private fun calculatePointForPosition(position: Int, radius: Float): Point {
        val startAngle = Math.PI * (9.0F / 8.0F)
        val angle = startAngle + (position * (Math.PI / 4.0))

        return Point(
            (radius * cos(angle) + (width / 2.0F)).toFloat(),
            (radius * sin(angle) + (height / 2.0F)).toFloat()
        )
    }
}