package com.example.study_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {

    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // view를 activity로 가져오는 방법
        // 1. 직접 찾아서 가져오기
        //val textView : TextView = findViewById(R.id.hello)
        // 2. xml을 import해서 가져오기
        //hello

        // 익명함수
        // 1. 람다 방식
        hello.setOnClickListener{
            Log.d("click", "clicked")
        }

        // 2. 익명함수 방식
        hello.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("click","clicked")
            }
        })

        // 3. 이름이 필요한 경우(Click) // 가장 마지막에 적용된 리스너가 적용된다.
        val click = object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("click","clicked")
                hello.setText("안녕하세요") //set text
                image.setImageResource(R.drawable.ic_launcher_background)
                number += 10
                Log.d("number", "" + number)
            }
        }
        hello.setOnClickListener(click)

        // 뷰를 조작하는 함수들
        // set text
        // setImageResource
    }
}