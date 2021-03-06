package com.example.study_android

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener {
            /*val intent = Intent(this@Intent1, Intent2::class.java) // 요청을 만듬 @Intent1은 생략 가능 (@ 뒤)

            // Key, Value 방식 -> Key와 Value를 쌍으로 만들어 저장한다. (Dictionary)
            intent.putExtra("number1", 1)
            intent.putExtra("number2", 2)
            startActivityForResult(intent, 200) // 이름이 200이라는 거로 요청을 보냄*/

            // 위의 코드와 같지만 가독성을 높힌 코틀린 코드 (블럭으로 묶을 수 있음)
            /*val intent2 = Intent(this@Intent1, Intent2::class.java)
            // Apply -> this = intent2
            intent2.apply{
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivity(intent2)*/

            // 암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com")) // ACTION_VIEW 오른쪽에 있는 것을 보여주는것
            startActivity(intent)
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}