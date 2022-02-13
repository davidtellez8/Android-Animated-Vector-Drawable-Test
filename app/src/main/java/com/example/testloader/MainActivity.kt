package com.example.testloader

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat

class MainActivity : AppCompatActivity() {

    private var ivLoader: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getViews()
    }

    private fun getViews(){
        ivLoader = findViewById(R.id.ivLoader)
        animateView(ivLoader!!)
    }

    private fun animateView(view: ImageView) {
        val animated = AnimatedVectorDrawableCompat.create(this, R.drawable.avd_anim_loader)
        animated?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                //Loop animation
                view.post { animated.start() }
            }

        })
        view.setImageDrawable(animated)
        //Put the color you want
        view.setColorFilter(Color.BLACK)
        //Start animation
        animated?.start()
    }
}