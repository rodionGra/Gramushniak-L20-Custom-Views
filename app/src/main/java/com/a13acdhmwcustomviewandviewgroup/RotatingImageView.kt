package com.a13acdhmwcustomviewandviewgroup

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView


class RotatingImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defAttrs: Int = 0
) : AppCompatImageView(context, attributeSet, defAttrs) {

    // Initial position.
    private var rotationDegrees = 0
    var speed: Int = 0
        set(value) {
            if (value in 0..4) field = value
        }

    init {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_fan_black)
        setImageBitmap(bitmap)
    }

    override fun onDraw(canvas: Canvas) {
        // Translate rotation axe to the center.
        canvas.translate((width / 2).toFloat(), (height / 2).toFloat())
        // Rotate!
        canvas.rotate(rotation(speed).toFloat())
        // Put back to its original place.
        canvas.translate((-width / 2).toFloat(), (-height / 2).toFloat())
        // Invalidate the view.
        postInvalidateOnAnimation()
        super.onDraw(canvas)
    }

    private fun rotation(delta: Int): Int {
        rotationDegrees = (rotationDegrees + delta) % 360
        return rotationDegrees
    }

}