package com.example.study_android

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne:Fragment() {

    interface OnDataPassListener {
        fun onDataPass(data : String?)
    }

    lateinit var dataPasseListener: OnDataPassListener

    override fun onAttach(context: Context) {
        Log.d("life_cycle", "F onAttach")
        super.onAttach(context)
        dataPasseListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle", "F onCreateView")
        // fragment가 interface를 처음으로 그릴 때 호출된다.
        // inflater : 뷰를 그려주는 역할
        // container : 부모뷰

        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")

        val data = arguments?.getString("hello", "")
        Log.d("data", "" + data)

        super.onViewCreated(view, savedInstanceState)

        // Activity의 onCreate에서 했던 작업을 여기서 함
        pass.setOnClickListener{
            dataPasseListener.onDataPass("Good bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }
}