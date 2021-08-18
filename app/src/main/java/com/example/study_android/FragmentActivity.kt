package com.example.study_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("life_cycle", "onCreate")
        setContentView(R.layout.activity_fragment)

        button.setOnClickListener {
            // fragment를 동적으로 작동하는 방법
            val fragmentOne : FragmentOne = FragmentOne()
            val fragmentManager: FragmentManager = supportFragmentManager // Activity가 가지고 있음

            // Transaction
            val fragmentTransaction = fragmentManager.beginTransaction() // 트랜잭션 시작
            fragmentTransaction.replace(R.id.container, fragmentOne) // 트랜잭션 할 일
            fragmentTransaction.commit() // 트랜잭션 끝
            // 끝을 내는 방법
            // 1. commit -> 시간 될 때 해(좀 더 안정적)
            // 2. commitnow -> 지금 당장
            // 3. commitAllowingStateLoss -> 커밋이 안될수도 있음 그래도 상관없이 하겠다는 것
        }

    }

   override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}