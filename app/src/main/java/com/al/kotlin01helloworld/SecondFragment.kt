package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {
    private lateinit var root: View
    private lateinit var btnBack: Button

    // 一种方式
    private val myArgs by navArgs<SecondFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_second, container, false)
        btnBack = root.findViewById(R.id.btnBack)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvShow = root.findViewById<TextView>(R.id.tvShow)

        // 可以从 Bundle 直接获取
        // val message = arguments?.getInt("number") ?: "无"
        // tvShow.text = message.toString()

        tvShow.text = myArgs.number.toString()

        btnBack.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.firstFragment2)
        }
    }
}