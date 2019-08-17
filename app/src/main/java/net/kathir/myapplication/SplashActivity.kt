package net.kathir.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity()
{

    private val SPLASH_DISPLAY_LENGTH = 8000

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity,MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        },SPLASH_DISPLAY_LENGTH.toLong())
    }
}