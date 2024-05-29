package com.example.mybmi_calculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var value = weight / (height / 100.0).pow(2.0) //키(m단위)
        value = round(value * 10) / 10

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if (value < 18.5) {
            resultText = "저체중"
            resImage = R.drawable.underweight
            resColor = Color.YELLOW
        } else if (18.5 <= value && value < 23.0) {
            resultText = "정상체중"
            resImage = R.drawable.normal
            resColor = Color.GREEN
        } else if (23.0 <= value && value < 25.0) {
            resultText = "과체중"
            resImage = R.drawable.overweigth
            resColor = Color.BLACK
        } else if (25.0 <= value && value < 30.0) {
            resultText = "경도비만"
            resImage = R.drawable.obese
            resColor = Color.GREEN
        } else if (30.0 <= value && value < 35.0) {
            resultText = "중정도비만"
            resImage = R.drawable.ex_obese
            resColor = Color.MAGENTA
        } else {
            resultText = "고도비만"
            resImage = R.drawable.exex
            resColor = Color.RED
        }

        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = value.toString()
        tv_resText.text = resultText
        iv_image.setImageResource(resImage)
        tv_resText.setTextColor(resColor)

        btn_back.setOnClickListener {
            finish() //
        }
    }
}