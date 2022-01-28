package com.themunsi.ui.splash

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnimationUtils
import androidx.core.animation.doOnEnd
import com.themunsi.MainActivity
import com.themunsi.R

class SpashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spash_screen)


        Handler().postDelayed({
            val intent = Intent(this, Proceed::class.java)
            startActivity(intent)
            finish()
        }, 3000)


    }
}