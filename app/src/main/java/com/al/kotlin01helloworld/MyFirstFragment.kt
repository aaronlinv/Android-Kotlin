package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [MyFirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyFirstFragment(val name: String) : Fragment() {
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_my_first, container, false)

        tvInfo = root.findViewById(R.id.textViewInfo)
        tvInfo.text = name
        return root
    }
}