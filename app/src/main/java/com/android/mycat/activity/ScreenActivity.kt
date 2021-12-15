package com.android.mycat.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.android.mycat.R
import com.android.mycat.databinding.ActivityScreenBinding

class ScreenActivity : AppCompatActivity() {

    private var binding: ActivityScreenBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        val title = findViewById<TextView>(R.id.tv_name)
//        val lottie = findViewById<LottieAnimationView>(R.id.home_animation)
//
//        title.animate().setDuration(1000).startDelay = 4000
//        lottie.animate().setDuration(1000).startDelay = 4000

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 7000)
    }
}