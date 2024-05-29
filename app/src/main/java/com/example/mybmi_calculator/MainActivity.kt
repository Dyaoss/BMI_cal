package com.example.mybmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val heightEditText =
            findViewById<EditText>(R.id.et_height) //변수 heightEditText에 et_height 연결
        val weightEditText =
            findViewById<EditText>(R.id.et_weight) //변수 weightEditText에 et_weight 연결
        val submitButton = findViewById<Button>(R.id.btn_check) //변수 submit에 btn_check 연결

        submitButton.setOnClickListener {

            if (heightEditText.text.isEmpty()) { //빈칸으로 두었을때 예외처리
                Toast.makeText(this, "신장을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (weightEditText.text.isEmpty()) {
                Toast.makeText(this, "체중을 입력해주세요!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString()
                .toInt() // height란 변수 선언 -> heightEditText에서 입력받은 수를 받아온다
            val weight: Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java) // activity간 데이터를 넘겨줄때 Intent 사용
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent) // mainActivity에서 resultActivity를 부른다

        }
    }
}