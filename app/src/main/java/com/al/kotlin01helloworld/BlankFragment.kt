package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BlankFragment(val num: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myLog("ViwePage2 $num 被实例化")
        val root = inflater.inflate(R.layout.fragment_blank, container, false)

        val tvInfo: TextView = root.findViewById(R.id.tvShow)
        tvInfo.text = num.toString()
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        myLog("ViewPage2 $num 被销毁了")
    }
}