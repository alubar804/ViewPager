package com.example.viewpager

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ZoomPageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        view.pivotX = (if (position < 0) 0 else view.width).toFloat()
        view.scaleX = if (position < 0) 1f + position else 1f - position
    }

    companion object {
        private val MIN_SCALE = 0.85f
        private val MIN_ALPHA = 0.5f
    }
}