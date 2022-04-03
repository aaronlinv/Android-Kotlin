package com.al.kotlin01helloworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.*

val MESSAGE_KEY = "MESSAGE_KEY"

class FirstFragment : Fragment() {
    private lateinit var tvRandom: TextView
    private lateinit var btnAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_first, container, false)
        tvRandom = root.findViewById(R.id.tvRandom)
        btnAdd = root.findViewById(R.id.btnSend)

        val navController = findNavController()
        btnAdd.setOnClickListener {

            val ranNumber = Random().nextInt(100)
            // 根据 navigation 视图的配置自动生成代码
            val action = FirstFragmentDirections.actionFirstFragment2ToSecondFragment2(ranNumber)

            navController.navigate(action)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}