package com.example.kotlinlearning

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init_text.textSize=16f
        init_text.setText(R.string.hello_kotlin)
        init_text.setTextColor(resources.getColor(R.color.red))
    }
}
