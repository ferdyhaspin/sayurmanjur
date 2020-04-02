package com.ferdyhaspin.sayurmanjur.ui.splash

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.ferdyhaspin.sayurmanjur.R
import com.ferdyhaspin.sayurmanjur.ui.main.MainActivity
import com.ferdyhaspin.sayurmanjur.util.main
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.delay

/**
 * Created by ferdyhaspin on 02/04/20.
 * Copyright (c) 2020 SayurMayur Apps All rights reserved.
 */

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        addAnimation()
        nextScreen()
    }

    private fun addAnimation() = main {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1f)
        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f)
        for (i in 1..3) {
            delay(500)
            ObjectAnimator.ofPropertyValuesHolder(ivLogo, scaleX, scaleY, alpha).apply {
                interpolator = OvershootInterpolator()
                duration = 450
            }.start()
            delay(1000L)
        }
    }

    private fun nextScreen() = main {
        delay(3000L)
        Intent(this@SplashActivity, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}