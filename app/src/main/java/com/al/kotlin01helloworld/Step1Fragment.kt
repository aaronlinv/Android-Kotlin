package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Step1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_step1, container, false)
        val btnStep1 = root.findViewById<Button>(R.id.btnStep1)
        btnStep1.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_step1Fragment_to_step2Fragment)
        }
        return root
    }
}