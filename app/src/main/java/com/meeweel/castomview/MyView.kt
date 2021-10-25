package com.meeweel.castomview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import java.util.jar.Attributes

class MyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    scale: ScaleType = ImageView.ScaleType.CENTER_CROP
) : AppCompatImageView(context, attrs, defStyleAttr) {

    // View = onMeasure -> onLayout -> onDraw
    //
    // ViewGroup = onMeasure -> onLayout

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom) // Расположение вьюшки
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) { // Размер вьюшки
        super.onMeasure(widthMeasureSpec, widthMeasureSpec) // Сделал размер квадратом
        // Тут лучше использовать ScaleType="centerCrop"
        scaleType = ScaleType.CENTER_CROP // Установил default scaleType
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas) // Визуал
    }
}