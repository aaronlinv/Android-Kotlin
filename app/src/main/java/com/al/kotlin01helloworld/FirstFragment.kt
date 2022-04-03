package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlin.system.exitProcess

class FirstFragment : Fragment() {
    private lateinit var btnStartWizard: Button
    private lateinit var btnExit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)
        btnStartWizard = root.findViewById(R.id.btnRunWizard)
        btnExit = root.findViewById(R.id.BtnExit)

        val navController = findNavController()
        btnStartWizard.setOnClickListener {
            navController.navigate(R.id.action_firstFragment2_to_secondFragment2)
        }
        btnExit.setOnClickListener {
            exitProcess(0)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}