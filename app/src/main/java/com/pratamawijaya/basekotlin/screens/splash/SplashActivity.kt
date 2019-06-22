package com.pratamawijaya.basekotlin.screens.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pratamawijaya.basekotlin.R
import com.pratamawijaya.basekotlin.screens.home.HomeActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        GlobalScope.launch(Dispatchers.Main) {
            delay(1000)
            startActivity<HomeActivity>()
            finish()
        }
    }
}
