package com.apress.qrcodedemo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_test.setOnClickListener {
            createBitmapByCanvas()
        }

    }

    fun createBitmapByCanvas() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_qr_code, null)
        view.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)
        iv_test.setImageBitmap(bitmap)
    }

    fun createBitmapFromView() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_qr_code, null)
        view.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.buildDrawingCache(true)
        val bitmap = view.drawingCache
        val createBitmap = Bitmap.createBitmap(bitmap)
        iv_test.setImageBitmap(createBitmap)
        bitmap.recycle()
        view.destroyDrawingCache()
    }
}
