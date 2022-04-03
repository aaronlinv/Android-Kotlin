package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlin.system.exitProcess

class WizardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_wizard, container, false)
        val btnBackFirstPage = root.findViewById<Button>(R.id.btnBackFirstPage)
        val btnRunWizard = root.findViewById<Button>(R.id.btnRestartWizard)
        val btnFinish = root.findViewById<Button>(R.id.btnFinish)

        val navController = findNavController()
        btnRunWizard.setOnClickListener {
            // 1. 可以通过 Nav 配置视图设置
            // navController.navigate(R.id.action_wizardFragment_to_secondFragment2)
            // 2. 默认 false 表示跳转到 一个新的 secondFragment2 ，原来的 栈中的 secondFragment2 会被保留
            navController.popBackStack(R.id.secondFragment2, false)
        }

        btnBackFirstPage.setOnClickListener {
            navController.navigate(R.id.action_wizardFragment_to_firstFragment2)
        }

        btnFinish.setOnClickListener {
            exitProcess(0)
        }

        return root
    }
}